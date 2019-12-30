package com.yangsanhe.library.service;

import com.yangsanhe.library.entity.Reader;
import com.yangsanhe.library.entity.ReaderType;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.vo.ReaderTableVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-30 10:49:06
 */
@Service
public interface ReaderService {
    void insertReader(Reader reader) throws CustomException;

    void deleteReader(String readerbarcode) throws CustomException;

    void editReader(Reader reader) throws CustomException;

    void insertReaderType(ReaderType readerType) throws CustomException;

    void deleteReaderType(Integer id) throws CustomException;

    void editReaderType(ReaderType readerType) throws CustomException;

    List<ReaderTableVO> queryReader() throws CustomException;

    List<ReaderType> queryReaderType() throws CustomException;
}
