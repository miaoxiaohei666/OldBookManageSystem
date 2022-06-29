package ccnu.cs.c2.g8.oldbookmanagesystem.control;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControl {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/account/login",method = RequestMethod.GET)
    public String userLogin(@RequestParam(name = "uno") Integer uno,@RequestParam(name = "upassword") String upassword) {
        System.out.println("userLogin");
        boolean result = userService.userLogin(uno, upassword);
        if (result){
            return "redirect:/index";
        }
        else return "/user";

    }

    @RequestMapping(value = "/account/useradd",method = RequestMethod.POST)
    public String userAdd(User user){
        userService.addUser(user);
        return "redirect:/" ;
    }
}
