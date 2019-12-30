package com.yangsanhe.library.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangsanhe
 * @date 2019-12-30 13:02:24
 */
@RestController
@RequestMapping("/borrow_return")
@RequiresPermissions("借还管理")
public class BorrowReturnController {

}
