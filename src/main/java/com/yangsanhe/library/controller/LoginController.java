package com.yangsanhe.library.controller;

import com.yangsanhe.library.error.CommonError;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.response.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author yangsanhe
 * @date 2019-12-30 14:04:14
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final HttpSession session;

    public LoginController(HttpSession session) {
        this.session = session;
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public Response loginCheck(String username, String password) throws CustomException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            session.setAttribute("username",username);
        }catch (Exception e){
            throw new CustomException(CommonError.LOGIN_FAILED);
        }
        return new Response();
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

}
