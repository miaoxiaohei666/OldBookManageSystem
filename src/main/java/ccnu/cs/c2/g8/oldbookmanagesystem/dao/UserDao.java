package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User getUserByUno(Integer uno);

    User getByUnoAndUpassword(Integer uno, String password);

    User saveAndFlush(User user);

}
