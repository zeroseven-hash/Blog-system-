package com.blog2.service;

import com.blog2.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
