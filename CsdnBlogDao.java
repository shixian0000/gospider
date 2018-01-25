package com.gospider;


import java.sql.*;

public class CsdnBlogDao {

    private Connection conn = null;
    private Statement stmt = null;

    public CsdnBlogDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?user=root&password=123456";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int add(CsdnBlog csdnBlog) {
        try {
            String sql = "INSERT INTO csdnblog (`id`, `title`, `date`, `tags`, `category`, `view`, `comments`, `copyright`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, csdnBlog.getId());
            ps.setString(2, csdnBlog.getTitle());
            ps.setString(3, csdnBlog.getDate());
            ps.setString(4, "1");
            ps.setString(5, "1");
            ps.setInt(6, 1);
            ps.setInt(7, 1);
            ps.setInt(8, 1);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}

