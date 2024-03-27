package com.example.smbms.service;

import com.example.smbms.dao.BaseDao;
import com.example.smbms.dao.UserDao;
import com.example.smbms.dao.UserDaoImpl;
import com.example.smbms.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        connection = BaseDao.getConnection();
        try {
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(connection, null);
        }

        System.out.println(user.getUserPassword());
        if (password.equals(user.getUserPassword())) {

            return user;
        }
        return null;
    }
}
