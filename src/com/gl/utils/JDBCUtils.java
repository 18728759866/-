package com.gl.utils;

import java.sql.*;

public class JDBCUtils {
    /**
     * 数据库的连接
     * @return
     */
    public static Connection getConnection()
    {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/mysqldata?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "gl010924";
        try {
            Class.forName(driver);  //加载数据库驱动程序
            conn = DriverManager.getConnection(dburl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 数据库的释放
     * @param conn
     * @param st
     * @param rs
     */
    public static void JdbcFree(Connection conn, Statement st, ResultSet rs)
    {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


