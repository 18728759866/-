package com.gl.dao.impl;

import com.gl.dao.JudgeDAO;
import com.gl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeDaoImpl implements JudgeDAO {
    @Override
    public void select(String projectID, String judgeID, String password) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into judgedata values(?,?,?,?)";
        try {
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1,projectID);
             pstmt.setString(2,judgeID);
             pstmt.setString(3,password);
             pstmt.setInt(4,1);
             pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public boolean ExistProject(String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select projectID from judgedata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (rs.getString(1).equals(projectID)){
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public boolean ExistJudge(String JudgeID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select judgeID from judgedata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (rs.getString(1).equals(JudgeID)){
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public String selectpasswordByJudgeID(String JudgeID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select password from judgedata where judgeID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,JudgeID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String password = rs.getString(1);
                return password;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public String selectprojectIDByJudgeID(String JudgeID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select projectID from judgedata where judgeID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,JudgeID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String projrctID = rs.getString(1);
                return projrctID;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public boolean CanVote(String judgename) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select vote from judgedata where judgeID = ?";
        try {
           pstmt =  conn.prepareStatement(sql);
           pstmt.setString(1,judgename);
           rs = pstmt.executeQuery();
           while (rs.next()){
               int vote = rs.getInt(1);
               if (vote ==1 ){
                   return true;
               }
               else {
                   return false;
               }
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public void UpdataVote(String judgename) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update judgedata set vote = ? where judgeID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,0);
            pstmt.setString(2,judgename);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public void DelectAll(String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "delete from judgedata where projectID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,projectID);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public void UpdataAllVote(String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update judgedata set vote = ? where projectID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.setString(2,projectID);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

}
