package com.gl.dao.impl;

import com.gl.dao.ProjectDAO;
import com.gl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDaoImpl implements ProjectDAO {

    @Override
    public void select(String userID,String projectID, String projectType,Integer votecount) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into projectdata values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            pstmt.setString(2,projectID);
            pstmt.setString(3,projectType);
            pstmt.setInt(4,votecount);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public void delete(String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "delete from projectdata where projectID = ?";
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
    public boolean creatproject(String userID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select userID from projectdata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (userID.equals(rs.getString(1))){
                    return false;
                }
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean ExistProject(String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select projectID from projectdata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (projectID.equals(rs.getString(1))){
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public boolean ExistUserID(String userID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select userID from projectdata";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (userID.equals(rs.getString(1))){
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public String SelectprojectIDByuserID(String userID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select projectID from projectdata where userID = ?";
        try {
            if (ExistUserID(userID)){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                return rs.getString(1);
            }
            }
            else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public Integer GetVoteCount(String userID,String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select votecount from projectdata where projectID = ? and userID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,projectID);
            pstmt.setString(2,userID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public void UpdataVoteCount(String userdata,String projectID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update projectdata set votecount = ? where projectID = ? and userID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            Integer count = new ProjectDaoImpl().GetVoteCount(userdata,projectID);
            count--;
            pstmt.setInt(1,count);
            pstmt.setString(2,projectID);
            pstmt.setString(3,userdata);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }
}
