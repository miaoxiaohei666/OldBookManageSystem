package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User getUserByUno(Integer uno);
    boolean findByUno(Integer uno);

    User getByUnoAndUpassword(Integer uno, String password);

    List<User> getAllOrderByUnlike();
}
