package com.epam.dao;

import com.epam.db.ConnectionFactory;
import com.epam.model.User;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;


public class UserDao {

    private static final String SELECT_FROM_USERS_BY_USERID = "SELECT * FROM users WHERE userid=?";

    public static User getUser(Long id) {
        try {
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement statement = cn.prepareStatement(SELECT_FROM_USERS_BY_USERID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();


            while (rs.next()) {
                User user = new User();
                user.setUserid(id);
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surName"));
                user.setEmail(rs.getString("email"));
                user.setLawstatus(rs.getString("lawStatus"));
                return user;

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final String SELECT_FROM_USERS = "SELECT * FROM users";


    public static Set<User> getAllUsers() {
        try {
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement statement = cn.prepareStatement(SELECT_FROM_USERS);
            ResultSet rs = statement.executeQuery();

            Set<User> userSet = new HashSet<>();

            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getLong("userid"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setLawstatus(rs.getString("lawstatus"));
                userSet.add(user);
            }

            return userSet;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static final String INSERT_INTO_USERS = "INSERT INTO users(userid, name, surname, email, lawstatus) VALUES (?, ?, ?, ?, ?)";

    public static boolean insertUser(User user) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_USERS);
            ps.setLong(1, user.getUserid());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getLawstatus());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }



    private static final String DELETE_FROM_USERS = "DELETE FROM users WHERE userid=?";

    public static boolean deleteUser(Long id) {
        try (Connection cn = ConnectionFactory.getConnection()) {
            try (PreparedStatement ps = cn.prepareStatement(DELETE_FROM_USERS)) {

                ps.setLong(1, id);
                ps.execute();

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
