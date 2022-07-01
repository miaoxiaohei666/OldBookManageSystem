package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "/index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/denglu";
    }

    @RequestMapping("toRegister")
    public String toRegister() {
        return "/zhuce";
    }

    @RequestMapping(value = "/user/account/login")
    public String userLogin(@RequestParam(name = "uno") Integer uno, @RequestParam(name = "upassword") String upassword) {
        boolean result = userService.userLogin(uno, upassword);
        if (result) {
            return "/index";
        } else return "/denglu";
    }

    @RequestMapping(value = "/user/account/register")
    public String userAdd(User user) {
        if (userService.addUser(user)) {
            return "/index";
        } else return "/zhuce";
    }

    @RequestMapping(value = "/admin/account/ban")
    public String userBan(@RequestParam(name = "uno") Integer uno) {
        if (userService.updateUstate(uno)) {
            return uno.toString();
        } else return "/index";
    }

    @RequestMapping(value = "/admin/account")
    public List<User> getAllByUnlike() {
        return userService.getUserUnlike();
    }
}
