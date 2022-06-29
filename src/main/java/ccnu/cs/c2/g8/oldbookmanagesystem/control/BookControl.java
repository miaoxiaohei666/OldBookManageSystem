package ccnu.cs.c2.g8.oldbookmanagesystem.control;


import ccnu.cs.c2.g8.oldbookmanagesystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControl {
    @Autowired
    private BookService bookService;
}
