package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/abandonvote")
public class AbandonVote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        new JudgeDaoImpl().UpdataVote((String)req.getSession().getAttribute("judgeID"));
        resp.sendRedirect("http://localhost:8080/LastProject_war/login_succes.jsp");
    }
}
