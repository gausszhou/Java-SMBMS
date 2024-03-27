package com.example.smbms.service;

import com.example.smbms.pojo.User;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login("admin", "123456");
        System.out.println(user.getUserName());
    }
}
