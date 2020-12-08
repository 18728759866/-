package com.gl.service;

import com.gl.dao.impl.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancreatproject")
public class CanCreatProject extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        if (new ProjectDaoImpl().creatproject(username)){
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatproject.jsp");
        }
        else {
            resp.sendRedirect("http://localhost:8080/LastProject_war/cantcreat.jsp");
        }

    }
}
