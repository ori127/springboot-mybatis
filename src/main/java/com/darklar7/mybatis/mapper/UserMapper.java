package com.darklar7.mybatis.mapper;

import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends MyMapper<User> {
}