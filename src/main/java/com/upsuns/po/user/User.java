package com.upsuns.po.user;

/*
 * Created by KinderRiven on 2017/2/26.
 */
public class User {

    private Integer userId;

    private String userName;

    private String password;

    public User(){}

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
