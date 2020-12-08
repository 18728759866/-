package com.gl.service;

import com.gl.dao.impl.JudgeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/judgelogin")
public class JudgeLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        String projectID = req.getParameter("projectID");
        String password = req.getParameter("password");
        if (new JudgeDaoImpl().ExistJudge(id)){
            if (!projectID.equals(new JudgeDaoImpl().selectprojectIDByJudgeID(id))){
                req.getSession().setAttribute("message2","项目ID输入错误！");
                resp.sendRedirect("http://localhost:8080/LastProject_war/judgelogin.jsp");
            }
            else {
                if (!password.equals(new JudgeDaoImpl().selectpasswordByJudgeID(id))){
                    req.getSession().setAttribute("message2","密码错误！");
                    resp.sendRedirect("http://localhost:8080/LastProject_war/judgelogin.jsp");
                }
            }
        }
        else {
            req.getSession().setAttribute("message2","评委ID不存在！");
            resp.sendRedirect("http://localhost:8080/LastProject_war/judgelogin.jsp");
        }
        if (new JudgeDaoImpl().ExistJudge(id) && projectID.equals(new JudgeDaoImpl().selectprojectIDByJudgeID(id)) && password.equals(new JudgeDaoImpl().selectpasswordByJudgeID(id))){
            req.getSession().setAttribute("judgeID",id);
            resp.sendRedirect("http://localhost:8080/LastProject_war/judgelogin_succes.jsp");
        }

    }
}
