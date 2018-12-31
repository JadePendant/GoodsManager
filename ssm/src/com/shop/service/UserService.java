package com.shop.service;

import com.shop.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getAllUser();
    public int isLogin(Map<String,String> map);
    public int isRegiste(User user);
    public int addUser(User user);
    public void deleteUser(String username);
    public void updateUser(User user);
    public User searchUser(String username);

}
