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
    public String bookAddPublish(@RequestBody Book book,Integer uno) {
        if (bookService.addBook_Publish(book,uno)){
            return "/book/mine";
        }
        else return "/book/add_publish";
    }

    @RequestMapping(value = "/user/add_want",method = RequestMethod.POST)
    public boolean bookAddWant(Integer bno,Integer uno) {
        return bookService.addBook_Want(bno, uno);
    }

    @RequestMapping(value = "/user/mine/ban",method = RequestMethod.GET)
    public boolean bookBan(Integer bno) {
        return bookService.updateBstate(bno);
    }

    @RequestMapping(value = "/user/mine/publish",method = RequestMethod.GET)
    public List<Book> getBookPublish(Integer uno) {
        return bookService.getBookPublish(uno);
    }

    @RequestMapping(value = "/user/mine/want",method = RequestMethod.GET)
    public List<Book> getBookWant(Integer uno) {
        return bookService.getBookWant(uno);
    }

    @RequestMapping(value = "/user/book_sort",method = RequestMethod.GET)
    public List<Book> getBookSort(Integer sno) {
        return bookService.getAllBySno(sno);
    }

    @RequestMapping(value = "/admin/book",method = RequestMethod.GET)
    public List<Book> getBookUnlike(Integer sno) {
        return bookService.getAllBySno(sno);
    }
}
