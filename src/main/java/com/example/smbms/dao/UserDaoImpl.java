package com.example.smbms.dao;

import com.example.smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        ResultSet result = null;
        User user = null;
        String sql = "select * from smbms_user where userCode = ?";
        Object[] params = {userCode};

        result = BaseDao.execute(connection, sql, params);
        if (result.next()) {
            user = new User();
            user.setId(result.getInt("id"));
            user.setUserCode(result.getString("userCode"));
            user.setUserName(result.getString("userName"));
            user.setAddress(result.getString("address"));
            user.setBirthday(result.getDate("birthday"));
            user.setCreatedBy(result.getInt("createdBy"));
            user.setUserPassword(result.getString("userPassword"));
        }
        BaseDao.close(null, result);
        return user;
    }
}
