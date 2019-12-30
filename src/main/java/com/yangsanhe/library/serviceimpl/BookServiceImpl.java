package com.yangsanhe.library.serviceimpl;

import com.yangsanhe.library.dao.BookMapper;
import com.yangsanhe.library.dao.BookTypeMapper;
import com.yangsanhe.library.entity.Book;
import com.yangsanhe.library.entity.BookType;
import com.yangsanhe.library.error.CommonError;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.service.BookService;
import com.yangsanhe.library.vo.BookTableVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-29 21:30:54
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final BookTypeMapper bookTypeMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookTypeMapper bookTypeMapper) {
        this.bookMapper = bookMapper;
        this.bookTypeMapper = bookTypeMapper;
    }

    @Override
    public void insertBook(Book book) throws CustomException {
        if(book == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookMapper.insertSelective(book) == 0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void deleteBook(String bookbarcode) throws CustomException {
        if(bookbarcode == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookMapper.deleteByPrimaryKey(bookbarcode)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void editBook(Book book) throws CustomException {
        if(book == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookMapper.updateByPrimaryKeySelective(book)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void insertBookType(BookType bookType) throws CustomException {
        if(bookType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookTypeMapper.insertSelective(bookType)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void deleteBookType(Integer id) throws CustomException {
        if(id == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookTypeMapper.deleteByPrimaryKey(id)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }

    }

    @Override
    public void editBookType(BookType bookType) throws CustomException {
        if(bookType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookTypeMapper.updateByPrimaryKeySelective(bookType)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public List<BookTableVO> queryBook() throws CustomException {
        List<BookTableVO> bookTableVOS = new ArrayList<>();
        List<Book> books = bookMapper.queryAllBooks();
        for (Book book : books) {
            BookType bookType = bookTypeMapper.selectByPrimaryKey(book.getBooktype());
            bookTableVOS.add(this.bookConverter(book,bookType));
        }
        return bookTableVOS;
    }

    @Override
    public List<BookType> queryBookType() throws CustomException {
        return bookTypeMapper.queryAllTypes();
    }

    private BookTableVO bookConverter(Book book, BookType bookType) throws CustomException{
        if(book == null || bookType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        BookTableVO bookTableVO = new BookTableVO();
        try {
            BeanUtils.copyProperties(bookTableVO,book);
            BeanUtils.copyProperties(bookTableVO,bookType);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bookTableVO;
    }

}
