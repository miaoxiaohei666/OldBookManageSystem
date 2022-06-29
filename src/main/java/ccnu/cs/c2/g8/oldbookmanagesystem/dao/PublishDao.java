package ccnu.cs.c2.g8.oldbookmanagesystem.dao;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.PrimaryKey.PublishKey;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublishDao extends JpaRepository<Publish, PublishKey> {
    List<Integer> getAllByUno(Integer uno);
}
