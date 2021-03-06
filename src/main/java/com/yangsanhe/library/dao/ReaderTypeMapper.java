package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.ReaderType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReaderTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReaderType record);

    int insertSelective(ReaderType record);

    ReaderType selectByPrimaryKey(Integer id);

    List<ReaderType> queryAllTypes();

    int updateByPrimaryKeySelective(ReaderType record);

    int updateByPrimaryKey(ReaderType record);
}