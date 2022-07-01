package ccnu.cs.c2.g8.oldbookmanagesystem.controller;


import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/user/add_publish",method = RequestMethod.POST)
    public String bookAddPublish(@RequestBody Book book,@RequestParam(name = "uno") Integer uno) {
        if (bookService.addBook_Publish(book,uno)){
            return "/book/mine";
        }
        else return "/book/add_publish";
    }

    @RequestMapping(value = "/user/add_want",method = RequestMethod.POST)
    public boolean bookAddWant(@RequestParam(name = "bno") Integer bno,@RequestParam(name = "uno") Integer uno) {
        return bookService.addBook_Want(bno, uno);
    }

    @RequestMapping(value = "/user/mine/ban",method = RequestMethod.GET)
    public boolean bookBan(@RequestParam(name = "bno") Integer bno) {
        return bookService.updateBstate(bno);
    }

    @RequestMapping(value = "/user/mine/publish",method = RequestMethod.GET)
    public List<Book> getBookPublish(@RequestParam(name = "uno")Integer uno) {
        return bookService.getBookPublish(uno);
    }

    @RequestMapping(value = "/user/mine/want",method = RequestMethod.GET)
    public List<Book> getBookWant(@RequestParam(name = "uno")Integer uno) {
        return bookService.getBookWant(uno);
    }

    @RequestMapping(value = "/user/book_sort",method = RequestMethod.GET)
    public List<Book> getBookSort(@RequestParam(name = "sno")Integer sno) {
        return bookService.getAllBySno(sno);
    }

    @RequestMapping(value = "/admin/book",method = RequestMethod.GET)
    public List<Book> getBookUnlike(@RequestParam(name = "sno")Integer sno) {
        return bookService.getAllBySno(sno);
    }
}
