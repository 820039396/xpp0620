package com.qf.bim.utils;

import java.sql.*;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BaseDao {
    final static String DRIVER=Env.newInstance().getProperty("jdbc.driver");
    final static String URL=Env.newInstance().getProperty("jdbc.url");
    final static String USERNAME=Env.newInstance().getProperty("jdbc.username");
    final static String PASSWORD=Env.newInstance().getProperty("jdbc.password");

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getConnect(){
        try {
           this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeAll(){
        try {
            if (rs!=null)  rs.close();
            if (pstmt!=null)  pstmt.close();
            if (conn!=null)  conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
