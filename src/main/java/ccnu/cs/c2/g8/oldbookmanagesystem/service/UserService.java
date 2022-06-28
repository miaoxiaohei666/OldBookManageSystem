package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.UserDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserService {
    @Autowired
    private UserDao userDao;

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

    public User userLogin(Integer uno, String password) {
        try {
            return userDao.getByUnoAndUpassword(uno, password);
        } catch (Exception e) {
            System.out.println("userLogin wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean isUser(Integer uno) {
        boolean flag = false;
        try {
            userDao.getUserByUno(uno);
            flag = true;
        } catch (Exception e) {
            System.out.println("isUser wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public User findUserByUno(Integer uno) {
        try {
            return userDao.getUserByUno(uno);
        } catch (Exception e) {
            System.out.println("findUserByUno wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUstate(Integer uno){
        boolean flag = false;
        try{
            User user = userDao.getUserByUno(uno);
            user.setUstate(!user.isUstate());
            flag = true;
        }catch (Exception e){
            System.out.println("updateUstate wrong!");
            e.printStackTrace();
        }
        return flag;
    }
}
