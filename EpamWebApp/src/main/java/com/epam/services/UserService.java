package com.epam.services;

import com.epam.model.User;
import com.epam.dao.UserDao;

import java.sql.SQLException;
import java.util.Set;

public class UserService {
    public static User getUser(Long id){
        return UserDao.getUser(id);
    }

    public static Set<User>  getAllUsers() {
        return UserDao.getAllUsers();
    }

    public static boolean insertUser(User user) throws SQLException, ClassNotFoundException {
        return UserDao.insertUser(user);
    }

    public static boolean deleteUser(Long id) {
        return UserDao.deleteUser(id);
    }
}
