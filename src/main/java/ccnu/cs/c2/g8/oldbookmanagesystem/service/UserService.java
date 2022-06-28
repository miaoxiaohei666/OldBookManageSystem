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
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public User userLogin(Integer uno, String password) {
        boolean flag = false;
        try {
            return userDao.getByUnoAndUpassword(uno, password);
            flag = true;
        } catch (Exception e) {
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteUser(Integer uno) {
        boolean flag = false;
        try {
            userDao.deleteById(uno);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean findall(Integer uno) {
        boolean flag = false;
        try {
            userDao.findUserByUno(uno);
            flag = true;
        } catch (Exception e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean findPublish(Integer uno) {
        boolean flag = false;
        try {
            userDao.findPublishByUno(uno);
            flag = true;
        } catch (Exception e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean findWant(Integer uno) {
        boolean flag = false;
        try {
            userDao.findWantByUno(uno);
            flag = true;
        } catch (Exception e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateUnickname(Integer uno, String unickname) {
        boolean flag = false;
        try {
            userDao.updateUserUnicknameByUno(uno, unickname);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateUpassword(Integer uno, String password) {
        boolean flag = false;
        try {
            userDao.updateUserUpasswordByUno(uno, password);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }
}
