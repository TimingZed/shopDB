package com.timing.service;

import com.timing.pojo.User;

import java.util.List;

public interface IUserService {

    /**
     * 查询所有用户
     * @return 用户集
     */
    List<User> listUser();

    /**
     * 查询用户信息
     * @param id 用户编号
     * @return 用户信息
     */
    User findUserId(Integer id);

    /**
     * 添加用户
     * @param user 用户信息
     */
    void saveUser(User user);

    /**
     * 删除用户
     * @param removeUserId 删除用户的编号数组
     */
    void removeUserId(Integer[] removeUserId);
}
