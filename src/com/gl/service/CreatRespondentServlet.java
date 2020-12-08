package com.gl.service;

import com.gl.dao.impl.RespondentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creatrespondent")
public class CreatRespondentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String introduce = req.getParameter("introduce");
        if (name == ""){
            req.getSession().setAttribute("message5","请输入姓名");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatrespondent.jsp");
        }
        else if (introduce == ""){
            req.getSession().setAttribute("message5","请输入介绍");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatrespondent.jsp");
        }
        if (name != "" && introduce != ""){
            String projectID = (String)req.getSession().getAttribute("projectID");
            new RespondentDaoImpl().select(name,introduce,projectID);
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatRespondent_succes.jsp");
        }
    }
}
