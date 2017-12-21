package com.darklar7.mybatis.service;

import com.darklar7.mybatis.mapper.RoleMapper;
import com.darklar7.mybatis.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaojunli
 * @date 2017/12/21
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findByUserId(Long userid){
        return roleMapper.findByUserId(userid);
    }
}
