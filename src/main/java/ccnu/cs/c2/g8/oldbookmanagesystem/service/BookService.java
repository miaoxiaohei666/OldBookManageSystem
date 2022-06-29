package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public boolean addBook(Book book){
        boolean flag = false;
        try{
            bookDao.save(book);
            flag=true;
        }catch(Exception e){
            System.out.println("addBook wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteBook(Integer bno){
        boolean flag = false;
        try{
            bookDao.deleteById(bno);
            flag=true;
        }catch(Exception e){
            System.out.println("deleteBook wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateBstate(Integer bno){
        boolean flag = false;
        try{
            Book book = bookDao.getBookByBno(bno);
            book.setBstate(!book.isBstate());
            flag=true;
        }catch(Exception e){
            System.out.println("updateBstate wrong!");
            e.printStackTrace();
        }
        return flag;
    }

}
