package com.asianrapid.security;

import com.asianrapid.dao.SysRoleUserMapper;
import com.asianrapid.dao.SysUserMapper;
import com.asianrapid.po.SysRole;
import com.asianrapid.po.SysRoleUser;
import com.asianrapid.po.SysUser;
import com.asianrapid.po.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {


    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SysUserMapper userMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) { // 重写loadUserByUsername 方法获得 userdetails  类型用户

//        SysUser user = userMapper.findByUserName(username);
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> users = userMapper.selectByExample(example);
        SysUser user = users.get(0);
        System.err.println("----------------");
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        //查询用户权限
        List<SysRoleUser> roleUsers = sysRoleUserMapper.selectByuserId(user.getId());


        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        //将权限信息交给security
        for (SysRoleUser roleUser : roleUsers) {
            authorities.add(new SimpleGrantedAuthority(roleUser.getRole().getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}