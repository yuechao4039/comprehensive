package com.sndj.user;

import com.sndj.ingredient.BaseResp;
import com.sndj.ingredient.RowsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
      
    @RequestMapping("/showinfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId){  
        User userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);  
        return "/user";
    }  
      
    @RequestMapping(value = "/showinfos", method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<RowsRep<UserInfo>> showUserInfos(){
        RowsRep<UserInfo> baseResp = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(baseResp);
    }  
}  