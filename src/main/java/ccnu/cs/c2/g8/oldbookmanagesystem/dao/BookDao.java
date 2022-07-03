package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    Book getBookByBno(Integer Bno);

    List<Book> getBookBySnoAndBstateIsFalse(Integer sno);

    @Modifying
    @Query(value = "update book set bdescribe=?, bname=?, bpicture=?, bprice=?, bstate=?, create_time=?, sno=? where bno=?",
            nativeQuery = true)
    int updateBook(String bdescribe, String bname, String bpicture, Double bprice, boolean bstate, String create_time, Integer sno, Integer bno);
}