package com.study.index.bean;

/**
 * @ProjectName: study_card_index
 * @Package: com.study.index.bean
 * @ClassName: User
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/4/22 10:57
 * @Version: 1.0
 */
public class User {

    private String userId;
    private String userAccount;
    private String userName;
    private String userPhone;
    private String password;
    private String userEmail;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
