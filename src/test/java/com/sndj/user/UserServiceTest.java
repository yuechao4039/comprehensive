package com.sndj.user;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 创建时间：2015-1-27 下午10:45:38
 *
 * @author andy
 * @version 2.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class UserServiceTest {

    private static final Logger LOGGER = Logger
            .getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;


    @Test
    public void testQueryById1() {
        User userInfo = userService.getUserById(1);
        LOGGER.info(JSON.toJSON(userInfo));
    }

    @Test
    public void testQueryAll() {
//        List<User> userInfos = userService.getUsers();
//        LOGGER.info(JSON.toJSON(userInfos));
    }

    @Test
    public void testInsert() {
        User userInfo = new User();
        userInfo.setId(3);
        userInfo.setUsername("SNDJ");
        userInfo.setAge(29);
        int result = userService.insert(userInfo);
        System.out.println(result);
    }
}