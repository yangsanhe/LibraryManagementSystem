package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Bookshelf;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookshelfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookshelf record);

    int insertSelective(Bookshelf record);

    Bookshelf selectByPrimaryKey(Integer id);

    List<Bookshelf> queryAllbookshelves();

    int updateByPrimaryKeySelective(Bookshelf record);

    int updateByPrimaryKey(Bookshelf record);
}