package com.shop.service;

import com.shop.domain.User;
import com.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        List<User> list =null;
        list = userMapper.getAllUser();

        return list;
    }

    @Override
    public int isLogin(Map<String,String> map) {
        /*调用dao层*/
        User user =userMapper.getUserWithName(map.get("username"));
        System.out.println(user);
        if(user!=null)
        {
            if(user.getPassword().equals(map.get("password")))
                return 1;
            return 0;
        }
        return 2;
    }

    @Override
    public int isRegiste(User user) {
        if(userMapper.getUserWithName(user.getUsername())==null)
        {
            userMapper.registeUser(user);
            return 1;
        }
        return 0;
    }

    @Override
    public int addUser(User user) {
        if(userMapper.getUserWithName(user.getUsername())==null)
        {
            userMapper.addUser(user);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User searchUser(String username) {
        return userMapper.getUserWithName(username);
    }
}
