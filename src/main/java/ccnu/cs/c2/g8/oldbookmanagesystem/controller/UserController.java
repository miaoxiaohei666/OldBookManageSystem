package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

//    @RequestMapping("/")
//    public String index() {
//        return "redirect:/user/book_sort/grade1";
//    }

    @RequestMapping("/")
    public String indexToLogin() {
        return "/denglu";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "redirect:/user/book_sort/grade1";
    }

//    @RequestMapping("/toLogin")
//    public String toLogin() {
//        return "/denglu";
//    }

    @RequestMapping("toRegister")
    public String toRegister() {
        return "/zhuce";
    }

    @RequestMapping(value = "/user/account/login")
    public String userLogin(@RequestParam(name = "uno") Integer uno, @RequestParam(name = "upassword") String upassword) {
        try {
            //如果是管理员            return "administer";
            if (userService.userLogin(uno, upassword)) return "redirect:/user/book_sort/grade1";
        } catch (Exception e) {
            System.out.println("userLogin wrong!");
            e.printStackTrace();
        }
        return "/denglu";
    }

    @RequestMapping(value = "/user/account/register")
    public String userAdd(User user) {
        try {
            if (userService.addUser(user)) return "redirect:/user/book_sort/grade1";
        } catch (Exception e) {
            System.out.println("userAdd wrong!");
            e.printStackTrace();
        }
        return "/zhuce";
    }

    @RequestMapping(value = "/admin/account/ban")
    public String userBan(@RequestParam(name = "uno") Integer uno) {
        try {
            if (userService.updateUstate(uno)) return uno.toString();
        } catch (Exception e) {
            System.out.println("userBan wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/admin/account")
    public String getAllByUnlike(Model model) {
        try {
            model.addAttribute("getBookPublish", userService.getUserUnlike());
            return "/index";
        } catch (Exception e) {
            System.out.println("getAllByUnlike wrong!");
            e.printStackTrace();
        }
        return "/error";
    }
}
