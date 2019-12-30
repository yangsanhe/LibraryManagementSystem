package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Record;
import com.yangsanhe.library.entity.RecordKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordMapper {
    int deleteByPrimaryKey(RecordKey key);
    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(RecordKey key);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}