package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;
import com.gl.dao.impl.RespondentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/judgevote")
public class JudgeVoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (new JudgeDaoImpl().CanVote((String) req.getSession().getAttribute("judgeID"))){
            String username = req.getParameter("username");
            new RespondentDaoImpl().UpdateVote(username);
            new JudgeDaoImpl().UpdataVote((String) req.getSession().getAttribute("judgeID"));
            req.getRequestDispatcher("/votesuccess.jsp").forward(req,resp);
        }
        else {
            req.getSession().setAttribute("message3","评委已投过票！");
            resp.sendRedirect("http://localhost:8080/LastProject_war/judgevote.jsp");
        }

    }
}
