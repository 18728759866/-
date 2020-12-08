package com.gl.dao.impl;

import com.gl.dao.RespondentDAO;
import com.gl.pojo.Respondent;
import com.gl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RespondentDaoImpl implements RespondentDAO {
    @Override
    public void select(String ID, String introduce,String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into respondentdata values(?,?,?,?)";
        try {
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,ID);
           pstmt.setInt(2,0);
           pstmt.setString(3,introduce);
           pstmt.setString(4,projectID);
           pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public List ReturnName() {
        ArrayList NameList = new ArrayList();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select username from respondentdata";
        try {
           pstmt = conn.prepareStatement(sql);
           rs = pstmt.executeQuery();
           while (rs.next()){
             NameList.add(rs.getString(1));
           }
           return NameList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public List ReturnVote() {
        ArrayList VoteList= new ArrayList();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select score from respondentdata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                VoteList.add(rs.getString(1));
            }
            return VoteList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public List ReturnIntroduce() {
        ArrayList IntroduceList = new ArrayList();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select introduce from respondentdata";
        try {
           pstmt = conn.prepareStatement(sql);
           rs = pstmt.executeQuery();
           while (rs.next()){
               IntroduceList.add(rs.getString(1));
           }
            return IntroduceList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public void UpdateVote(String username) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update respondentdata set score = ? where username = ?";
        int vote = new RespondentDaoImpl().GetVoteByUsername(username);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vote+1);
            pstmt.setString(2,username);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }

    }

    @Override
    public Integer GetVoteByUsername(String username) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select score from respondentdata where username = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Integer vote = Integer.parseInt(rs.getString(1));
                return vote;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public List GetRespondent(String projectID1) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from respondentdata where projectID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,projectID1);
            rs = pstmt.executeQuery();
            List<Respondent> respondentlist =new  ArrayList<Respondent>();
            while (rs.next()){
                Respondent respondent = new Respondent();
                String username = rs.getString(1);
                respondent.setName(username);
                int score = rs.getInt(2);
                respondent.setScore(score);
                String introduce = rs.getString(3);
                respondent.setIntroduce(introduce);
                String projectID = rs.getString(4);
                respondent.setProjectID(projectID);
                respondentlist.add(respondent);
            }
            return respondentlist;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public String GetUsernameByscore(int score,String project) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select username from respondentdata where score = ? and projectID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,score);
            pstmt.setString(2,project);
            rs = pstmt.executeQuery();
            List<Respondent> list = new ArrayList<Respondent>();
            while (rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
/**
 * 改和增方法一般用executeUpdate()
 */
