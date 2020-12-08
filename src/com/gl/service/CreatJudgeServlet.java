package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;
import com.gl.dao.impl.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creatjudge")
public class CreatJudgeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectID = req.getParameter("projectID");
        if (new ProjectDaoImpl().ExistProject(projectID)) {
            String judgeID = req.getParameter("judgeID");
            if (new JudgeDaoImpl().ExistJudge(judgeID)){
                req.getSession().setAttribute("message1","评委ID已存在，请换一个！");
                resp.sendRedirect("http://localhost:8080/LastProject_war/creatjudge.jsp");
            }
            else {
                String password = req.getParameter("password");
                new JudgeDaoImpl().select(projectID, judgeID, password);
                resp.sendRedirect("http://localhost:8080/LastProject_war/creatjudge_succes.jsp");
            }
        }
        else {
            req.getSession().setAttribute("message1","项目ID不存在，请重新输入！");
            resp.sendRedirect("http://localhost:8080/LastProject_war/creatjudge.jsp");
        }
    }
}
