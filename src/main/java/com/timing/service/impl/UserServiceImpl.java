package com.timing.service.impl;

import com.timing.dao.IUserDao;
import com.timing.pojo.User;
import com.timing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> listUser() {

        List<User> list=userDao.listUser();
        return list;
    }

    @Override
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    @Override
    public void removeUserId(Integer[] removeUserId) {
        userDao.removeUserId(removeUserId);
    }

    @Override
    public User findUserId(Integer id) {
        return userDao.findUserId(id);
    }
}
