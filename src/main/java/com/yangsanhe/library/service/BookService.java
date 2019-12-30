package com.yangsanhe.library.service;

import com.yangsanhe.library.entity.Book;
import com.yangsanhe.library.entity.BookType;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.vo.BookTableVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-29 21:29:48
 */
@Service
public interface BookService {

    void insertBook(Book book) throws CustomException;

    void deleteBook(String bookbarcode) throws CustomException;

    void editBook(Book book) throws CustomException;

    void insertBookType(BookType bookType) throws CustomException;

    void deleteBookType(Integer id) throws CustomException;

    void editBookType(BookType bookType) throws CustomException;

    List<BookTableVO> queryBook() throws CustomException;

    List<BookType> queryBookType() throws CustomException;
}
