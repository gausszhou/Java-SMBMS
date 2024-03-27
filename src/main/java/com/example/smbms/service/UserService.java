package com.example.smbms.service;

import com.example.smbms.pojo.User;

public interface UserService {
    public User login(String userCode, String password);
}
