package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;
import com.gl.dao.impl.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/nextvote")
public class NextVote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (new ProjectDaoImpl().GetVoteCount((String)req.getSession().getAttribute("username"),(String)req.getSession().getAttribute("projectID")) > 0)
        new JudgeDaoImpl().UpdataAllVote((String)req.getSession().getAttribute("projectID"));
        new ProjectDaoImpl().UpdataVoteCount((String)req.getSession().getAttribute("username"),(String)req.getSession().getAttribute("projectID"));
        resp.sendRedirect("http://localhost:8080/LastProject_war/NextVote_succes.jsp");
    }
}
