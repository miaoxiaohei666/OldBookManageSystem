package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.PublishDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.WantDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Transactional
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
            book.getCreatetime();
            bookDao.save(book);
            publish.setUno(uno);
            publish.setBno(book.getBno());
            publishDao.save(publish);
            flag = true;
        } catch (Exception e) {
            System.out.println("addBook to publish wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean editBook(Book book) {
        boolean flag = false;
        try {
            bookDao.updateBook(book.getBdescribe(), book.getBname(), book.getBpicture(), book.getBprice(), book.isBstate(), book.getCreatetime(), book.getSno(), book.getBno());
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

    public  boolean deleteBook(Integer bno){
        boolean flag=false;
        try{
            bookDao.deleteBookByBno(bno);
            flag=true;
        }catch (Exception e){
            System.out.println("delete wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public List<Book> getBookPublish(Integer uno) {
        try {
            List<Publish> bnoList = publishDao.getAllByUno(uno);
            List<Book> bookList = new ArrayList<Book>();
            Iterator<Publish> itr=bnoList.listIterator();
            while (itr.hasNext()) {
                bookList.add(bookDao.getBookByBno(itr.next().getBno()));
            }
            return bookList;
        } catch (Exception e) {
            System.out.println("getBookPublish wrong1!");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBookWant(Integer uno) {
        try {
            List<Want> bnoList = wantDao.getAllByUno(uno);
            List<Book> bookList = new ArrayList<Book>();
            Iterator<Want> itr=bnoList.listIterator();
            while (itr.hasNext()) {
                bookList.add(bookDao.getBookByBno(itr.next().getBno()));
            }
            return bookList;
        } catch (Exception e) {
            System.out.println("getBookWant wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBySno(Integer sno) {
        try {
            return bookDao.getBookBySnoAndBstateIsFalse(sno);
        } catch (Exception e) {
            System.out.println("getAllBySno wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteBookFormPublish(Integer uno, Integer bno) {
        try {
            publishDao.deleteByUnoAndBno(uno,bno);
            return true;
        } catch (Exception e) {
            System.out.println("getAllBySno wrong!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBookFormWant(Integer bno, Integer uno) {
        try {
            wantDao.deleteByUnoAndBno(uno, bno);
            return true;
        } catch (Exception e) {
            System.out.println("getAllBySno wrong!");
            e.printStackTrace();
        }
        return false;
    }

    public Book getBookByBno(Integer bno){
        try{
            return bookDao.getBookByBno(bno);
        } catch (Exception e) {
            System.out.println("getBookByBno wrong!");
            e.printStackTrace();
        }
        return null;
    }
}
