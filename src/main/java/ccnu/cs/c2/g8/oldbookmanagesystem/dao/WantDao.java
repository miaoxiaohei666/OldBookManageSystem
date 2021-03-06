package ccnu.cs.c2.g8.oldbookmanagesystem.dao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.primarykey.WantKey;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantDao extends JpaRepository<Want, WantKey>{
    List<Want> getAllByUno(Integer uno);

    Integer deleteByUnoAndBno(Integer uno,Integer bno);
}
