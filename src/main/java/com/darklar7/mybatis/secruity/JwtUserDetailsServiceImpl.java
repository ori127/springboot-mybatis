package com.darklar7.mybatis.secruity;

import com.darklar7.mybatis.mapper.RoleMapper;
import com.darklar7.mybatis.mapper.UserMapper;
import com.darklar7.mybatis.model.Role;
import com.darklar7.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        List<Role> list = roleMapper.findByUserId(user.getId());
        List<String> stringList = new ArrayList<>();
        for (Role item : list) {
            stringList.add(item.getRole());
        }
        user.setRoles(stringList);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
