package com.vakhnenko.departments.service;

import com.vakhnenko.departments.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User getOne(long id);

    User findByUsername(String username);

    List<User> getAll();
}
