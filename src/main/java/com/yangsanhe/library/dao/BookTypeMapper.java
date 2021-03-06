package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer id);

    List<BookType> queryAllTypes();

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
}