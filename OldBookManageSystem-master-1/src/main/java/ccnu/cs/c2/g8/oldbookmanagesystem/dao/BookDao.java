package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    @Query(value="update Book set Book.bprice=price where Book.bno=Bno")
    public Integer updateBookBpriceByUno(String Bno,Double price);

    @Query(value="update Book set Book.bdescibe=describe where Book.bno=Bno")
    public Integer updateBookBdescribeByUno(String Bno,String describe);

    @Query(value="update Book set Book.bstate=state where Book.bno=Bno")
    public Integer updateBookBstateByUno(String Bno,boolean state);

}