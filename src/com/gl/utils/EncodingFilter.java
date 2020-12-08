package com.gl.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class EncodingFilter implements Filter {

    //这个类用来对编码形式进行规范 ：UTF-8
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

