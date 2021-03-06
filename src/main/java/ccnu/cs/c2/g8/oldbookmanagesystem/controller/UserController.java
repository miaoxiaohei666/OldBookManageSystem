package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/")
    public String indexToLogin() {
        return "/denglu";
    }

    @RequestMapping("/toLoginOut")
    public String toLoginOut() {
        return "/denglu";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "redirect:/user/book_sort/grade1";
    }

    @RequestMapping("/sort")
    public String toSort() {
        return "redirect:/user/book_sort";
    }

    @RequestMapping("/UserManage")
    public String administerToUserManage() {
        return "redirect:/admin/account";
    }

    @RequestMapping("/BookManage")
    public String administerToBookManage() {
        return "/BookManage";
    }

    @RequestMapping("/BookSort")
    public String administerToBookSort() {
        return "redirect:/admin/sort/all";
    }

    @RequestMapping("/toPublishBook")
    public String toPublishBook() {
        return "/publishBook";
    }

    @RequestMapping("/toMyPublishBook")
    public String toMyPublishBook() {
        return "redirect:/user/mine/publish";
    }

    @RequestMapping("/toMyWantBook")
    public String toMyWantBook() {
        return "redirect:/user/mine/want";
    }

    @RequestMapping("/toCustomHonesty")
    public String toCustomHonesty() {
        return "redirect:/user/mine/customHonesty";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "/zhuce";
    }


    @RequestMapping(value = "/user/account/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "uno") Integer uno, @RequestParam(name = "upassword") String upassword) {
        try {
            if (uno == 1234567890 && upassword.equals("root"))
                return "/administer";
            else if (userService.userLogin(uno, upassword)) {
                Cookie cookie = new Cookie("uno", uno.toString());
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
                return "redirect:/user/book_sort/grade1";
            }
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
            if (userService.updateUstate(uno)) return "redirect:/UserManage";
        } catch (Exception e) {
            System.out.println("userBan wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/admin/account")
    public String getAllByUnlike(Model model) {
        try {
            model.addAttribute("getAllByUnlike", userService.getUserUnlike());
            return "/UserManage";
        } catch (Exception e) {
            System.out.println("getAllByUnlike wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/customHonesty")
    public String getUserByUno(Model model,@CookieValue(name = "uno") Integer uno){
        try{
            model.addAttribute( "getUserHonestyByUno", userService.getUserByUno(uno));
            return "/customHonesty";
        } catch (Exception e) {
            System.out.println("getUserByUno wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/getUserByBno")
    public String getUserByBno(Model model,@RequestParam(name = "bno") Integer bno){
        try{
            model.addAttribute( "getUserByBno", userService.getUserByBno(bno));
            return "/customHonesty";
        } catch (Exception e) {
            System.out.println("getUserByBno wrong!");
            e.printStackTrace();
        }
        return "/error";
    }


}
