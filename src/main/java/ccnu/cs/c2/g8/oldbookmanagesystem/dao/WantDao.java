package ccnu.cs.c2.g8.oldbookmanagesystem.dao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.PrimaryKey.WantKey;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantDao extends JpaRepository<Want, WantKey>{
    List<Integer> getAllByUno(Integer uno);
}
