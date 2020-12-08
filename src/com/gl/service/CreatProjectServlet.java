package com.gl.service;

import com.gl.dao.impl.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creatproject")
public class CreatProjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String votecounts = req.getParameter("votecount");

        if (id == ""){
            req.getSession().setAttribute("message4","请输入项目ID");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatproject.jsp");
        }
        else if (type == ""){
            req.getSession().setAttribute("message4","请输入项目类型");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatproject.jsp");
        }
        else if (votecounts == ""){
            req.getSession().setAttribute("message4","请输入项目轮数");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatproject.jsp");
        }
        if (id != "" && type != "" && votecounts != ""){
            Integer votecount = Integer.valueOf(req.getParameter("votecount"));
            String userID = (String) req.getSession().getAttribute("username");
            new ProjectDaoImpl().select(userID,id,type,votecount);
            req.getSession().setAttribute("projectID",id);
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatProject_succes.jsp");
        }

    }
}
