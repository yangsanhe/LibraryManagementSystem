package com.yangsanhe.library.controller;

import com.yangsanhe.library.entity.Reader;
import com.yangsanhe.library.entity.ReaderType;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.response.Response;
import com.yangsanhe.library.service.ReaderService;
import com.yangsanhe.library.vo.ReaderTableVO;
import com.yangsanhe.library.vo.ResponseTableVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-30 10:48:01
 */
@RestController
@RequestMapping("/reader")
@RequiresPermissions("读者管理")
public class ReaderController {
    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }


    @PostMapping("/addReader")
    public Response addReader(Reader reader) throws CustomException {
        readerService.insertReader(reader);
        return new Response();
    }

    @PostMapping("/deleteReader")
    public Response deleteReader(String readerbarcode) throws CustomException {
        readerService.deleteReader(readerbarcode);
        return new Response();
    }

    @PostMapping("/editReader")
    public Response editReader(Reader reader) throws CustomException {
        readerService.editReader(reader);
        return new Response();
    }

    @PostMapping("/addReaderType")
    public Response addReaderType(ReaderType readerType) throws CustomException{
        readerService.insertReaderType(readerType);
        return new Response();
    }

    @PostMapping("/deleteReaderType")
    public Response deleteReaderType(Integer id) throws CustomException {
        readerService.deleteReaderType(id);
        return new Response();
    }

    @PostMapping("/editReaderType")
    public Response editReaderType(ReaderType readerType) throws CustomException {
        readerService.editReaderType(readerType);
        return new Response();
    }

    @RequestMapping("/getAllReaders")
    public ResponseTableVO getAllReaders() throws CustomException{
        List<ReaderTableVO> readerTableVOS = readerService.queryReader();
        return new ResponseTableVO(readerTableVOS.size(),readerTableVOS);
    }

    @RequestMapping("/getAllReaderTypes")
    public ResponseTableVO getAllReaderTypes() throws CustomException{
        List<ReaderType> readerTypes = readerService.queryReaderType();
        return new ResponseTableVO(readerTypes.size(),readerTypes);
    }


}
