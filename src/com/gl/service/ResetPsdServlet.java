package com.gl.service;

import com.gl.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/resetpsd")
public class ResetPsdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (!userDao.UpdataByEmail(email,password)) {
            req.getSession().setAttribute("notExist", "输入的邮箱不存在！");
            resp.sendRedirect("http://localhost:8080/LastProject_war/ResettingPassword.jsp");
        }
        else if (password == ""){
            req.getSession().setAttribute("notExist", "请输入密码！");
            resp.sendRedirect("http://localhost:8080/LastProject_war/ResettingPassword.jsp");
        }
        else {
            resp.sendRedirect("http://localhost:8080/LastProject_war/ResetPsa_succes.jsp");
        }
    }
}
