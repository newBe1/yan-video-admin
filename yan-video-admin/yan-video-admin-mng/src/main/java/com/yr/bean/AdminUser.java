package com.yr.bean;



/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/15 16:26
 */
public class AdminUser {
    private String userToken;
    private String username;
    private String password;

    public AdminUser() {
    }

    public AdminUser(String username, String password, String userToken) {
        super();
        this.username = username;
        this.password = password;
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
