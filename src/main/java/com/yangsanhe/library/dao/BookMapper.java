package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    int deleteByPrimaryKey(String bookbarcode);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bookbarcode);

    List<Book> queryAllBooks();

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}