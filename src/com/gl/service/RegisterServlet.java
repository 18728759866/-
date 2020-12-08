package com.gl.service;

import com.gl.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        String userID = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //获取Session中的验证码
        String key = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        if (!code.equalsIgnoreCase(key)) {
             req.getSession().setAttribute("message","验证码错误");
             resp.sendRedirect("http://localhost:8080/LastProject_war/register.jsp");
        }

        else {
            if (userDao.ExistUserID(userID)) {
                req.getSession().setAttribute("message", "用户名已存在");
                resp.sendRedirect("http://localhost:8080/LastProject_war/register.jsp");
            } else {
                userDao.Select(userID, password, email);
                req.getSession().setAttribute("username",userID);
                resp.sendRedirect("http://localhost:8080/LastProject_war/register_succes.jsp");
            }

        }

    }
}
