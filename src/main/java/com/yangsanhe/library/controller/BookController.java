package com.yangsanhe.library.controller;

import com.yangsanhe.library.entity.Book;
import com.yangsanhe.library.entity.BookType;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.response.Response;
import com.yangsanhe.library.service.BookService;
import com.yangsanhe.library.vo.BookTableVO;
import com.yangsanhe.library.vo.ResponseTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-29 21:28:59
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public Response addBook(Book book) throws CustomException {
        bookService.insertBook(book);
        return new Response();
    }

    @PostMapping("/deleteBook")
    public Response deleteBook(String bookbarcode) throws CustomException {
        bookService.deleteBook(bookbarcode);
        return new Response();
    }

    @PostMapping("/editBook")
    public Response editBook(Book book) throws CustomException {
        bookService.editBook(book);
        return new Response();
    }

    @PostMapping("/addBookType")
    public Response addBookType(BookType bookType) throws CustomException{
        bookService.insertBookType(bookType);
        return new Response();
    }

    @PostMapping("/deleteBookType")
    public Response deleteBookType(Integer id) throws CustomException {
        bookService.deleteBookType(id);
        return new Response();
    }

    @PostMapping("/editBookType")
    public Response editBookType(BookType bookType) throws CustomException {
//        System.out.println(bookType.getTypename());
//        System.out.println(bookType.getBorrowdays());
        bookService.editBookType(bookType);
        return new Response();
    }

    @RequestMapping("/getAllBooks")
    public ResponseTableVO getAllBooks() throws CustomException{
        List<BookTableVO> bookTableVOS = bookService.queryBook();
        return new ResponseTableVO(bookTableVOS.size(),bookTableVOS);
    }

    @RequestMapping("/getAllBookTypes")
    public ResponseTableVO getAllBookTypes() throws CustomException{
        List<BookType> bookTypes = bookService.queryBookType();
        return new ResponseTableVO(bookTypes.size(),bookTypes);
    }

}
