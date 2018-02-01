package com.sndj.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
  
/**   
 * 创建时间：2015-1-28 下午1:17:27   
 * @author andy   
 * @version 2.2   
 */  
@Controller  
@RequestMapping("/user")  
public class UserController {  
  
    @Autowired  
    private UserService userService;  
      
    @RequestMapping("/showInfo/{userId}")  
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId){  
        User userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);  
        return "/user";
    }  
      
    @RequestMapping("/showInfos")  
    public @ResponseBody Object showUserInfos(){  
        List<User> userInfos = userService.getUsers();
        return userInfos;  
    }  
}  