package com.darklar7.mybatis.mapper;

import com.darklar7.mybatis.model.Role;
import com.darklar7.mybatis.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RoleMapper extends MyMapper<Role> {
    List<Role> findByUserId(Long userid);
}