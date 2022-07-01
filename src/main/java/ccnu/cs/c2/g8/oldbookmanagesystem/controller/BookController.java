package ccnu.cs.c2.g8.oldbookmanagesystem.controller;


import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/user/add_publish")
    public String bookAddPublish(Book book, @RequestParam(name = "uno") Integer uno) {
        try {
            if(bookService.addBook_Publish(book, uno)) return "/index";
        } catch (Exception e) {
            System.out.println("bookAddPublish wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/add_want")
    public String bookAddWant(@RequestParam(name = "bno") Integer bno, @RequestParam(name = "uno") Integer uno) {
        try {
            if(bookService.addBook_Want(bno, uno)) return "/index";
        } catch (Exception e) {
            System.out.println("bookAddWant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/ban")
    public String bookBan(@RequestParam(name = "bno") Integer bno) {
        try {
            if(bookService.updateBstate(bno)) return "/index";
        } catch (Exception e) {
            System.out.println("bookAddWant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/publish")
    public String getBookPublish(Model model, @RequestParam(name = "uno") Integer uno) {
        try{
            model.addAttribute("getBookPublish", bookService.getBookPublish(uno));
            return "/index";
        }catch (Exception e){
            System.out.println("getBookPublish wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/want")
    public String getBookWant(Model model, @RequestParam(name = "uno") Integer uno) {
        try{
            model.addAttribute("getBookWant", bookService.getBookWant(uno));
            return "/index";
        }catch (Exception e){
            System.out.println("getBookWant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/book_sort")
    public String getBookBySort(Model model, @RequestParam(name = "sno") Integer sno) {
        try{
            model.addAttribute("getBookBySort", bookService.getAllBySno(sno));
            return "/index";
        }catch (Exception e){
            System.out.println("getBookBySort wrong!");
            e.printStackTrace();
        }
        return "/error";
    }
}
