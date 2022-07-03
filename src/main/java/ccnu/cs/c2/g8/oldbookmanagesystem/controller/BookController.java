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
    public String bookAddPublish(Book book, @CookieValue(value = "uno") Integer uno) {
        try {
            book.getCreatetime();
            if (bookService.addBook_Publish(book, uno)) return "/mypublishbook";
        } catch (Exception e) {
            System.out.println("bookAddPublish wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/add_want")
    public String bookAddWant(@RequestParam(name = "bno") Integer bno, @CookieValue(value = "uno") Integer uno) {
        try {
            if (bookService.addBook_Want(bno, uno)) return "redirect:/index";
        } catch (Exception e) {
            System.out.println("bookAddWant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/banpublish")
    public String bookBanPublish(@RequestParam(name = "bno") Integer bno, @CookieValue(value = "uno") Integer uno) {
        try {
            if (bookService.updateBstate(bno) && bookService.deleteBookFormPublish(uno,bno)) return "redirect:/user/mine/publish";
        } catch (Exception e) {
            System.out.println("bookBanPublish wrong!");
            e.printStackTrace();
        }
        return "/error";
    }
    @RequestMapping(value = "/user/mine/banwant")
    public String bookBanwant(@RequestParam(name = "bno") Integer bno, @CookieValue(value = "uno") Integer uno) {
        try {
            if (bookService.deleteBookFormWant(bno, uno)) return "redirect:/user/mine/want";
        } catch (Exception e) {
            System.out.println("bookBanwant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/publish")
    public String getBookPublish(Model model, @CookieValue(value = "uno") Integer uno) {
        try {
            model.addAttribute("getBookPublish", bookService.getBookPublish(uno));
            return "/mypublishbook";
        } catch (Exception e) {
            System.out.println("getBookPublish wrong2!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/mine/want")
    public String getBookWant(Model model, @CookieValue(value = "uno") Integer uno) {
        try {
            model.addAttribute("getBookWant", bookService.getBookWant(uno));
            return "/want";
        } catch (Exception e) {
            System.out.println("getBookWant wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/book_sort")
    public String getBookBySort(Model model, @RequestParam(name = "sno") Integer sno) {
        try {
            model.addAttribute("getBookByGrade1", bookService.getAllBySno(sno));
            return "/index";
        } catch (Exception e) {
            System.out.println("getBookBySort wrong!");
            e.printStackTrace();
        }
        return "/error";
    }


    @RequestMapping(value = "/user/book_sort/grade1")
    public String getBookByGrade1(Model model) {
        try {
            model.addAttribute("getBookByGrade1", bookService.getAllBySno(1));
            return "/index";
        } catch (Exception e) {
            System.out.println("getBookByGrade1 wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/book/edit")
    public String editBook(Book book, @CookieValue(name = "uno") Integer uno) {
        try {
            System.out.println(book.getBno().toString());
            book.getCreatetime();
            bookService.addBook_Publish(book,uno);
            return "redirect:/user/mine/publish";
        } catch (Exception e) {
            System.out.println("editBook wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping("/toEditPublishBook")
    public String toEditPublishBook(Model model, @RequestParam(name = "bno") Integer bno){
        try{
            model.addAttribute("books", bookService.getBookByBno(bno));
            return "/editPublishBook";
        } catch (Exception e) {
            System.out.println("toEditPublishBook wrong!");
            e.printStackTrace();
        }
        return "/error";
    }
}
