package com.shop.web;

import com.shop.domain.UserMessage;
import com.shop.domain.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
@Controller
public class UserController {
    /*注入业务层*/
    @Autowired
    private UserService userService;
    //获取所有用户接口
    @RequestMapping("user")
    @ResponseBody
    public UserMessage getAllUser(){
        UserMessage userMessage=new UserMessage();
        List<User> list =userService.getAllUser();
        userMessage.setOk(1);
        userMessage.setMessage("查询成功");
        userMessage.setData(list);
        return userMessage;
    }
    //登录接口
    @RequestMapping(value = {"/login"},method = {RequestMethod.POST})
    @ResponseBody
    public UserMessage login(String username, String password){
        System.out.println("我是传来的值");
        System.out.println(username);
        System.out.println(password);
        int ok=0;/*0:密码错误,1:登录成功,2:用户名不存,
        /*把数据保存到数据库当中*/
        /*调用业务层 保存到数据库当中*/
        String[] messages ={"密码错误","登录成功","用户名不存在",};
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",username);
        hashMap.put("password",password);
        ok = userService.isLogin(hashMap);
        UserMessage userMessage = new UserMessage();
        userMessage.setOk(ok);
        userMessage.setMessage(messages[ok]);
        System.out.println(userMessage);
        return userMessage;
    }
    //注册接口
    @RequestMapping(value = {"/registe"},method = {RequestMethod.POST})
    @ResponseBody
    public UserMessage registe(User user){
        int ok=0;
        String[] messages ={"用户名已存在","注册成功",};
        ok=userService.isRegiste(user);
        UserMessage userMessage = new UserMessage();
        userMessage.setOk(ok);
        userMessage.setMessage(messages[ok]);
        return userMessage;
    }
    //添加用户
    @RequestMapping(value = {"/adduser"},method = {RequestMethod.POST})
    @ResponseBody
    public UserMessage add(User user){
        int ok=0;
        String[] messages ={"用户名已存在","添加成功",};
        ok=userService.addUser(user);
        UserMessage userMessage = new UserMessage();
        userMessage.setOk(ok);
        userMessage.setMessage(messages[ok]);
        return userMessage;
    }
    //删除用户
    @RequestMapping("deleteuser")
    @ResponseBody
    public UserMessage delete(String username){

        userService.deleteUser(username);
        UserMessage userMessage = new UserMessage();
        userMessage.setOk(1);
        userMessage.setMessage("删除成功");
        return userMessage;
    }
    //修改用户
    @RequestMapping(value = {"/updateuser"},method = {RequestMethod.POST})
    @ResponseBody
    public UserMessage update(User user){
        userService.updateUser(user);
        UserMessage userMessage = new UserMessage();
        userMessage.setOk(1);
        userMessage.setMessage("更改成功");
        return userMessage;
    }
    //查找用户
    @RequestMapping("searchuser")
    @ResponseBody
    public UserMessage search(String username){

        UserMessage userMessage = new UserMessage();
        User user = userService.searchUser(username);
        if(user==null)
        {
            userMessage.setOk(0);
            userMessage.setMessage("无此用户");
        }
        else{
            userMessage.setOk(1);
            userMessage.setMessage("查询成功");
            userMessage.setUser(user);
        }
        return userMessage;
    }

}
