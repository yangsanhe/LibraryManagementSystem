package com.yangsanhe.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangsanhe
 * @date 2019-12-09 22:36:41
 */
@Controller
public class IndexController {
    @RequestMapping("/{pageName}")
    public String innnerPage(@PathVariable String pageName){
        return pageName;
    }

}
