package com.yangsanhe.library.dao;

import com.yangsanhe.library.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> queryAllAdmin();

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}