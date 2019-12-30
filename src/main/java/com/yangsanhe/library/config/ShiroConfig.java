package com.yangsanhe.library.config;

import com.yangsanhe.library.shiro.ManageRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangsanhe
 * @date 2019-12-30 13:38:11
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //排除的页面
        filterChainDefinitionMap.put("/static/**","anon");
        //anon表示匿名访问，authc表示需要认证通过后才可以访问
        filterChainDefinitionMap.put("/login/**","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/*","authc");
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启shiro的注解（如@RequiresRoles，@RequiresPermissions）
     * @return DefaultAdvisorAutoProxyCreator {@link DefaultAdvisorAutoProxyCreator}
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 该配置将允许使用注解 @RequiresPermissions @RequiresRoles 来进行角色、权限检查
     * @return AuthorizationAttributeSourceAdvisor {@link AuthorizationAttributeSourceAdvisor}
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SecurityManager securityManager(ManageRealm manageRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(manageRealm);
        return securityManager;
    }

    /**
     * 自定义ManageRealm
     * @return ManageRealm {@link ManageRealm}
     */
    @Bean
    public ManageRealm manageRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        ManageRealm manageRealm = new ManageRealm();
        manageRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return manageRealm;
    }

    /**
     * 配置加密规则，采用md5二次加密，并且在Realm中也通过SimpleAuthenticationInfo返回了加密时使用的盐。
     * @return hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
}
