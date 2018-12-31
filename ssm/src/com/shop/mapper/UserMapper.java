package com.shop.mapper;

import com.shop.domain.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户信息
    public List<User> getAllUser();
    //注册用户
    public void registeUser(User user);
    //新增用户
    public void addUser(User user);
    //删除用户
    public void deleteUser(String username);
    //修改用户--用户名不可修改
    public void updateUser(User user);
    //根据姓名查询用户
    public User getUserWithName(String username);


}
