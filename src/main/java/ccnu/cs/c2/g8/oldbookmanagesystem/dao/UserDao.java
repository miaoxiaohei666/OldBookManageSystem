package ccnu.cs.c2.g8.oldbookmanagesystem.dao;


import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    public  User findUserByUno(Integer uno);

    @Query(value="update User set User.unickname=nickname where User.uno=Uno")
    Integer updateUserunicknameByUno(Integer Uno,String nickname);

    @Query(value="update User set User.upassword=password where User.uno=Uno")
    Integer updateUserUpasswordByUno(Integer Uno,String password);

    @Query(value="select Bname,Create_time,Bprice,Bdescribe,Bstate from Book ,Publish where Publish.uno=Uno and Publish.bno=Book .bno",nativeQuery = true)
    List<Book> findPublishByUno(Integer Uno);

    @Query(value="select Bname,Create_time,Bprice,Bdescribe,Bstate from Book ,Want where Want.uno=Uno and Want.bno=Book.bno")
    List<Book> findWantByUno(Integer Uno);

}
