package com.gl.service;

import com.gl.dao.impl.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteproject")
public class DeleteProjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectid = req.getParameter("ID");

        if (new ProjectDaoImpl().ExistProject(projectid)){
            new ProjectDaoImpl().delete(projectid);
            resp.sendRedirect("http://localhost:8080/LastProject_war/delete_succes.jsp");
        }
        else {
            req.getSession().setAttribute("message10","项目名不存在");
            resp.sendRedirect("http://localhost:8080/LastProject_war/deleteproject.jsp");
        }

    }
}
