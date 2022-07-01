package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SortDao extends JpaRepository<Sort,Integer> {

    List<Sort> findAll();

    Integer getSortBySname(String sname);

    List<Sort> getSortsBySgrade(String sgrade);
}
