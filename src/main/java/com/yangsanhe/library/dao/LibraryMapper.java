package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Library;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LibraryMapper {
    int deleteByPrimaryKey(Integer liraryId);

    int insert(Library record);

    int insertSelective(Library record);

    Library selectByPrimaryKey(Integer liraryId);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}