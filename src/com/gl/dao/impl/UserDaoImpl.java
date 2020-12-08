package com.gl.dao.impl;

import com.gl.dao.UserDAO;
import com.gl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDAO {


    public  boolean ExistUserID(String UserID) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select userID from userdata ";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (UserID.equals(rs.getString(1))){
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }


    public void Select(String userID, String password, String email) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into userdata(userID,password,email) values(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
    }

    @Override
    public void Delete() {

    }

    @Override
    public boolean UpdataByEmail(String email, String password) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update userdata set password = ? where email = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,password);
            pstmt.setString(2,email);
            int i = pstmt.executeUpdate();
            if (i !=0){
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException throwables) {
           throwables.printStackTrace();
        }finally {
            JDBCUtils.JdbcFree(conn,pstmt,rs);
        }
        return false;
    }

    @Override
    public boolean ExistUser(String userID, String password) {
        if (ExistUserID(userID)){
             if (password.equals(SelectPasswordByuserID(userID))){
                 return true;
             }
             else {
                 return false;
             }
        }
        return false;
    }

    @Override
    public String SelectPasswordByuserID(String userID) {
        if (ExistUserID(userID)){
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String sql = "select password from userdata where userID = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,userID);
                rs = pstmt.executeQuery();
                while (rs.next()){
                    String string = rs.getString(1);
                    return string;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            finally {
                JDBCUtils.JdbcFree(conn,pstmt,rs);
            }
        }
        return null;
    }
}
