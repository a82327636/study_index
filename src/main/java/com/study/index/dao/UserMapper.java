package com.study.index.dao;

import com.study.index.bean.User;

/**
 * @ProjectName: study_card_index
 * @Package: com.study.index.dao
 * @ClassName: UserMapper
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/4/22 14:00
 * @Version: 1.0
 */
public interface UserMapper {

    public User getByAccount(String account);

    public void register(User user);
}
