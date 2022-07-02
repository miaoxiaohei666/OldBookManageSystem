package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response, @RequestParam(name = "uno") Integer uno) {
        Cookie cookie = new Cookie("username", uno.toString());
        response.addCookie(cookie);
        return "/index";
    }
}


