package com.study.index.service;

import com.study.index.bean.User;
import com.study.index.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: study_card_index
 * @Package: com.study.index.service
 * @ClassName: UserService
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/4/22 11:04
 * @Version: 1.0
 */
@Service
public class UserService {

    @Autowired private UserMapper userMapper;

    public User getByAccount(String account){
        return userMapper.getByAccount(account);
    }

    public void register(User user){
        userMapper.register(user);
    }
}
