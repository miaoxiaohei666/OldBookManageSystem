package ccnu.cs.c2.g8.oldbookmanagesystem.control;


import ccnu.cs.c2.g8.oldbookmanagesystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookControl {
    @Autowired
    BookService bookService;
}
