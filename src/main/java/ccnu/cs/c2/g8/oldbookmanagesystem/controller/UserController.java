package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.annotation.UserLoginToken;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.TokenService;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public TokenService tokenService;

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "/index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/denglu";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "/zhuce";
    }

    //登录
    @PostMapping("/user/account/login")
    public Object userlogin( User user){
        com.alibaba.fastjson.JSONObject jsonObject=new com.alibaba.fastjson.JSONObject();
        User userForBase=userService.getUserByUno(user.getUno());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getUpassword().equals(user.getUpassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/user/account/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @RequestMapping(value = "/user/account/register",method = RequestMethod.POST)
    public String userAdd(@RequestBody User user){
        if(userService.addUser(user)){
            return "/user/index" ;
        }
        else return "/user/account/register";
    }

    @RequestMapping(value = "/admin/account/ban",method = RequestMethod.GET)
    public boolean userBan(@RequestParam(name = "uno") Integer uno){
        if(userService.updateUstate(uno)){
            return true;
        }
        else return false;
    }

    @RequestMapping(value = "/admin/account",method = RequestMethod.GET)
    public List<User> getAllByUnlike(){
        return userService.getUserUnlike();
    }
}
