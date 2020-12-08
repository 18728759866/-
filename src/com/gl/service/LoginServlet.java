package com.gl.service;

import com.gl.dao.impl.ProjectDaoImpl;
import com.gl.dao.impl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = null;
        String userID = req.getParameter("username");
        String password = req.getParameter("password");
        if (userID == "" && password != ""){
            info = "请输入ID";
        }
        if (userID != "" && password == ""){
            info = "请输入密码";
        }
        if (userID == "" && password == ""){
            info = "请输入ID和密码";
        }
        if (new UserDaoImpl().ExistUserID(userID)){
             if(new UserDaoImpl().ExistUser(userID,password)){

             }
             else {
                 info = "密码错误！";
             }
        }
        else {
            info = "用户名不存在！";
        }
        req.getSession().setAttribute("msg",info);
        if (info != null) {
            resp.sendRedirect("http://localhost:8080/LastProject_war/login.jsp");
        }
        else {
            req.getSession().setAttribute("username",userID);
            req.getSession().setAttribute("projectID",new ProjectDaoImpl().SelectprojectIDByuserID(userID));
            resp.sendRedirect("http://localhost:8080/LastProject_war/login_succes.jsp");
        }

    }
}
