package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReaderMapper {
    int deleteByPrimaryKey(String readerbarcode);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(String readerbarcode);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}