package com.asianrapid.service.impl;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.commons.MD5Util;
import com.asianrapid.commons.RuntimeException;
import com.asianrapid.dao.SysUserMapper;
import com.asianrapid.po.SysUser;
import com.asianrapid.po.SysUserExample;
import com.asianrapid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 上午 10:38 2018/2/24 0024
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertUser(SysUser user) {
        try{
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user.getUsername());
            List<SysUser> users = sysUserMapper.selectByExample(example);
            if (users.size() == 0){
                user.setPassword(MD5Util.encode(user.getPassword()));
                int insert = sysUserMapper.insert(user);
                return insert;
            }
            return 0;
        }catch (Exception e){
            throw new RuntimeException(500, "插入用户异常", e);
        }
    }

    @Override
    public AsianrapidResult login(SysUser user, HttpServletRequest request) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(MD5Util.encode(user.getPassword()));

        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers.size() == 1){
            HttpSession session = request.getSession();
            session.setAttribute("current", user);
            return AsianrapidResult.ok();
        }else {
            return AsianrapidResult.build(500, "用户名或密码不存在", null);
        }
    }
}
