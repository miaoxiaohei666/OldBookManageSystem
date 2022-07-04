package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.PublishDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.UserDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.WantDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PublishDao publishDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private WantDao wantDao;

    public boolean addUser(User user) {
        boolean flag = false;
        try {
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            System.out.println("addUser wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean userLogin(Integer uno, String password) {
        try {
            if(userDao.getByUnoAndUpassword(uno, password)!=null){
                return true;
            }
        } catch (Exception e) {
            System.out.println("userLogin wrong!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUser(Integer uno) {
        boolean flag = false;
        try {
            flag = userDao.findByUno(uno);
            return flag;
        } catch (Exception e) {
            System.out.println("isUser wrong!");
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByUno(Integer uno) {
        try {
            return userDao.getUserByUno(uno);
        } catch (Exception e) {
            System.out.println("findUserByUno wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUstate(Integer uno) {
        boolean flag = false;
        try {
            User user = userDao.getUserByUno(uno);
            user.setUstate(!user.isUstate());
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            System.out.println("updateUstate wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public List<Book> getPublish(User user) {
        List<Publish> bnoList = null;
        List<Book> bookList = new ArrayList<Book>();
        try {
            bnoList = publishDao.getAllByUno(user.getUno());
            while (!bnoList.iterator().hasNext()) {
                bookList.add(bookDao.getBookByBno(bnoList.iterator().next().getBno()));
            }
        } catch (Exception e) {
            System.out.println("getPublish wrong!");
            e.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getWant(User user) {
        List<Want> bnoList = null;
        List<Book> bookList = null;
        try {
            bnoList = wantDao.getAllByUno(user.getUno());
            while (bnoList.iterator().hasNext()) {
                bookList.add(bookDao.getBookByBno((bnoList.iterator().next().getBno())));
            }
        } catch (Exception e) {
            System.out.println("getWant wrong!");
            e.printStackTrace();
        }
        return bookList;
    }

    public List<User> getUserUnlike() {
        try {
            return userDao.findAllByOrderByUnlikeDesc();
        } catch (Exception e) {
            System.out.println("getUserUnlike wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByBno(Integer bno){
        try {
            return userDao.getUserByUno(publishDao.getByBno(bno));
        } catch (Exception e) {
            System.out.println("getUserUnlike wrong!");
            e.printStackTrace();
        }
        return null;
    }
}
