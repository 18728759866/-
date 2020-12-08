package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;
import com.gl.dao.impl.RespondentDaoImpl;
import com.gl.pojo.Respondent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/overvote")
public class OverVote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = new RespondentDaoImpl().GetRespondent((String)req.getSession().getAttribute("projectID"));
        Iterator iterator = list.iterator();
        int scoremax = 0;
        while (iterator.hasNext()){
           Respondent respondent =  (Respondent) iterator.next();
           if (respondent.getScore()>scoremax){
               scoremax = respondent.getScore();
           }
        }
        String name = new RespondentDaoImpl().GetUsernameByscore(scoremax,(String)req.getSession().getAttribute("projectID"));
        req.getSession().setAttribute("scoremax",scoremax);
        req.getSession().setAttribute("scorename",name);
        new JudgeDaoImpl().DelectAll((String)req.getSession().getAttribute("projectID"));
        resp.sendRedirect("http://localhost:8080/LastProject_war/overvote.jsp");
    }
}
