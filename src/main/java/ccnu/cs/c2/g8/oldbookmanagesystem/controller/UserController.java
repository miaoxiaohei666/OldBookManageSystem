package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/account/login",method = RequestMethod.GET)
    public String userLogin(@RequestParam(name = "uno") Integer uno,@RequestParam(name = "upassword") String upassword) {
        boolean result = userService.userLogin(uno, upassword);
        if (result){
            return "/user/index";
        }
        else return "/user/account/login";
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
