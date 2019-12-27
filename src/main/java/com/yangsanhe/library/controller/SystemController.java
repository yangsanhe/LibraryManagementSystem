package com.yangsanhe.library.controller;

import com.yangsanhe.library.entity.Library;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.response.Response;
import com.yangsanhe.library.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangsanhe
 * @date 2019-12-27 13:16:44
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    private final SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @RequestMapping("/libraryInfo")
    public Response getLibraryInfo(){
        return new Response(systemService.getLibraryInfo());
    }

    @PostMapping("/updateLibraryInfo")
    public Response updateLibraryInfo(Library library) throws CustomException {
        systemService.updateLibraryInfo(library);
        return new Response();
    }

}
