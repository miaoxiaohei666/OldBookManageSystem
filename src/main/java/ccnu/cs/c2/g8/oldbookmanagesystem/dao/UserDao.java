package ccnu.cs.c2.g8.oldbookmanagesystem.dao;


import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    public  User findUserByUno(Integer uno);
}
