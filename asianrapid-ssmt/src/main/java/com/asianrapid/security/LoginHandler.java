package com.asianrapid.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 上午 9:32 2018/3/21 0021
 */
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("current", user);

        getRedirectStrategy().sendRedirect(request, response, "view/home");
    }
}
