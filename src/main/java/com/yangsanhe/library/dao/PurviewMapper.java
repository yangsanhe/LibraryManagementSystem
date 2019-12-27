package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Purview;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PurviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Purview record);

    int insertSelective(Purview record);

    Purview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Purview record);

    int updateByPrimaryKey(Purview record);
}