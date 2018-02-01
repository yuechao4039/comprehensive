package com.sndj.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User getUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    public List<User> getUsers() {
        return userDao.selectAll();
    }

    @Transactional
    public int insert(User userInfo) {

        int result = userDao.insert(userInfo);
        System.out.println(result);
        return result;
    }
}
