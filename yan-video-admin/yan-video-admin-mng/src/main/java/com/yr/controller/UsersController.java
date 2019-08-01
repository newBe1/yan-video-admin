package com.yr.controller;
import java.util.UUID;

import com.yr.bean.AdminUser;
import com.yr.pojo.Users;
import com.yr.service.UsersService;
import com.yr.utils.IMoocJSONResult;
import com.yr.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/8/1 11:59
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping("login")
    @ResponseBody
    public IMoocJSONResult login(String username, String password,
                                 HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return IMoocJSONResult.errorMsg("账号密码不能为空");
        }else if(username.equals("neo") && password.equals("neo")){

            String token = UUID.randomUUID().toString();

            AdminUser adminUser = new AdminUser(username,password,token);
            request.getSession().setAttribute("sessionUser",adminUser);
            return IMoocJSONResult.ok(adminUser);
        }

        return IMoocJSONResult.ok("登陆失败 请重试");
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("list")
    @ResponseBody
    public IMoocJSONResult list(Users user , Integer page){
        PagedResult pagedResult = userService.userList(user,page == null ? 1 : page ,10);
        return IMoocJSONResult.ok(pagedResult);
    }

    @GetMapping("/userList")
    public String userList() {
        return "users/usersList	";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("sessionUser");
        return "login";
    }
}
