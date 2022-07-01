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

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublishDao publishDao;
    @Autowired
    private WantDao wantDao;


    public boolean addBook_Publish(Book book, Integer uno) {
        boolean flag = false;
        try {
            Publish publish = new Publish();
            publish.setUno(uno);
            publish.setBno(book.getBno());
            bookDao.save(book);
            publishDao.save(publish);
            flag = true;
        } catch (Exception e) {
            System.out.println("addBook to publish wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addBook_Want(Integer bno, Integer uno) {
        boolean flag = false;
        try {
            Want want = new Want();
            want.setBno(bno);
            want.setUno(uno);
            wantDao.save(want);
            flag = true;
        } catch (Exception e) {
            System.out.println("addBook to want wrong!");
            e.printStackTrace();
        }
        return flag;
    }


    public boolean updateBstate(Integer bno) {
        boolean flag = false;
        try {
            Book book = bookDao.getBookByBno(bno);
            book.setBstate(!book.isBstate());
            flag = true;
        } catch (Exception e) {
            System.out.println("updateBstate wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public List<Book> getBookPublish(Integer uno) {
        try {
            List<Integer> bnoList = publishDao.getAllByUno(uno);
            List<Book> bookList = null;
            while (bnoList.iterator().hasNext()) {
                bookList.add(bookDao.getBookByBno(bnoList.iterator().next()));
            }
            return bookList;
        } catch (Exception e) {
            System.out.println("getBookPublish wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBookWant(Integer uno) {
        try {
            List<Integer> bnoList = wantDao.getAllByUno(uno);
            List<Book> bookList = null;
            while (bnoList.iterator().hasNext()) {
                bookList.add(bookDao.getBookByBno(bnoList.iterator().next()));
            }
            return bookList;
        } catch (Exception e) {
            System.out.println("getBookPublish wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBySno(Integer sno) {
        try {
            List<Book> bookList = bookDao.getBookBySno(sno);
            return bookList;
        } catch (
                Exception e) {
            System.out.println("getBookPublish wrong!");
            e.printStackTrace();
        }
        return null;
    }
}
