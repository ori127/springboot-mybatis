package com.darklar7.mybatis.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Role {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色
     */
    private String role;

}