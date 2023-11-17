package com.auth.testing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auth.testing.entity.User;

public class UserDaoImpl implements UserDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

    public UserDaoImpl() {
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }

    @Override
    public User selectUser(String email) {
        User user = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                user = new User(id, name, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}