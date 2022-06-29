package ccnu.cs.c2.g8.oldbookmanagesystem.control;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControl {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login")
    public String login(User user) {
        boolean result = userService.userLogin(user.getUno(), user.getUpassword());
        if (result){
            return "redirect:/index";
        }
        else return "user/login";

    }
}
