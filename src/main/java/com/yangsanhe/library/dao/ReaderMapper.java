package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReaderMapper {
    int deleteByPrimaryKey(String readerbarcode);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> queryAllreaders();

    Reader selectByPrimaryKey(String readerbarcode);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}