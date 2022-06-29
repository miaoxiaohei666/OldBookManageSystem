package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.PublishDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.WantDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublishDao publishDao;
    @Autowired
    private WantDao wantDao;

    public boolean addBook_Publish(Book book, User user){
        boolean flag = false;
        try{
            Publish publish=new Publish();
            publish.setUno(user.getUno());
            publish.setBno(book.getBno());
            bookDao.save(book);
            publishDao.save(publish);
            flag=true;
        }catch(Exception e){
            System.out.println("addBook to publish wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addBook_Want(Book book, User user){
        boolean flag = false;
        try{
            Want want = new Want();
            want.setBno(book.getBno());
            want.setUno(user.getUno());
            wantDao.save(want);
            flag=true;
        }catch(Exception e){
            System.out.println("addBook to want wrong!");
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
