package com.yangsanhe.library.shiro;

import com.yangsanhe.library.service.SystemService;
import com.yangsanhe.library.util.LoggerUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author yangsanhe
 * @date 2019-12-30 13:50:38
 */
public class ManageRealm extends AuthorizingRealm {

    @Autowired
    private SystemService systemService;

    /**
     * 获取授权信息
     * @param principals
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String adminName = (String) principals.getPrimaryPrincipal();
        //获取用户权限信息
        Set<String> permissions = systemService.getAuthByAdminName(adminName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //授权
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 获取认证信息
     * @param token
     * @return  认证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String adminName = (String) token.getPrincipal();
        String password = systemService.getPasswordByAdminName(adminName);
        if(password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminName,password,"manageRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(adminName));
        return authenticationInfo;
    }

}
