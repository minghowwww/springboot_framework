package com.asianrapid.service;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.po.SysUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 上午 10:38 2018/2/24 0024
 */
@Service
public interface UserService {

    int insertUser(SysUser user);
    AsianrapidResult login(SysUser user, HttpServletRequest request);
}
