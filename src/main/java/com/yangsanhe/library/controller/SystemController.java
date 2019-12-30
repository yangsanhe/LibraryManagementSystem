package com.yangsanhe.library.controller;

import com.yangsanhe.library.entity.Admin;
import com.yangsanhe.library.entity.Bookshelf;
import com.yangsanhe.library.entity.Library;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.response.Response;
import com.yangsanhe.library.service.SystemService;
import com.yangsanhe.library.vo.AdminTableVO;
import com.yangsanhe.library.vo.ResponseTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/addManager")
    public Response addManager(Admin admin){
        systemService.insertManager(admin);
        return new Response();
    }

    @RequestMapping("/getAllManager")
    public ResponseTableVO getAllManager(){
        List<AdminTableVO> adminTableVOS = systemService.queryManager();
        return new ResponseTableVO(adminTableVOS.size(),adminTableVOS);
    }

    @PostMapping("/addBookshelf")
    public Response addBookshelf(Bookshelf bookshelf){
        systemService.insertBookshelf(bookshelf);
        return new Response();
    }

    @PostMapping("/deleteBookshelf")
    public Response deleteBookshelf(Integer id) throws CustomException {
        systemService.deleteBookshelf(id);
        return new Response();
    }

    @PostMapping("/editBookshelf")
    public Response editBookshelf(Bookshelf bookshelf) throws CustomException {
        systemService.editBookshelf(bookshelf);
        return new Response();
    }

    @RequestMapping("/getAllBookshelf")
    public ResponseTableVO getAllBookshelf(){
        List<Bookshelf> bookshelves = systemService.queryBookShelf();
        return new ResponseTableVO(bookshelves.size(),bookshelves);
    }

}
