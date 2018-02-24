package com.sndj.user;

import com.sndj.ingredient.RowsRep;
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

    public RowsRep<UserInfo> getUsers() {
        RowsRep<UserInfo> rowsRep = new RowsRep<UserInfo>();
        List<User> list = userDao.selectAll();
        for (User user : list) {
            UserInfo info = new UserInfo();
            info.setId(user.getId());
            info.setAge(user.getAge());
            info.setUsername(user.getUsername());
            rowsRep.add(info);
        }
        return rowsRep;
    }

    @Transactional
    public int insert(User userInfo) {

        int result = userDao.insert(userInfo);
        System.out.println(result);
        return result;
    }
}
