package com.study.common.shiro;

import java.io.Serializable;

/**
 * @ProjectName: study_card_index
 * @Package: com.study.common.shiro
 * @ClassName: ShiroUser
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/4/22 11:01
 * @Version: 1.0
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userAccount;
    private String userName;
    private String userPhone;

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
}
