package ccnu.cs.c2.g8.oldbookmanagesystem.biz;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BookBiz {
    private BookDao bookDao;
}
