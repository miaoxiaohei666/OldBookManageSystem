package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, String> {
    List<Book> findByUno(Integer uno);

    @Query(value = "update Book set Book.bprice=price where Book.bno=Bno")
    Integer updateBookBpriceByUno(Integer Bno, Integer price);

    @Query(value = "update Book set Book.bdescibe=describe where Book.bno=Bno")
    Integer updateBookBdescribeByUno(Integer Bno, String describe);

    @Query(value = "update Book set Book.bstate=state where Book.bno=Bno")
    Integer updateBookBstateByUno(Integer Bno, boolean state);

}