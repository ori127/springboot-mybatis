package com.darklar7.mybatis.controller;

import com.darklar7.mybatis.model.Role;
import com.darklar7.mybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaojunli
 * @date 2017/12/21
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("role/{userid}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userid){
        List<Role> list = roleService.findByUserId(userid);
        return ResponseEntity.ok(list);
    }
}
