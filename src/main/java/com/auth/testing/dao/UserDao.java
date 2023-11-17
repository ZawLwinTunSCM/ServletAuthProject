package com.auth.testing.dao;

import com.auth.testing.entity.User;

public interface UserDao {
    public User selectUser(String email);
}
