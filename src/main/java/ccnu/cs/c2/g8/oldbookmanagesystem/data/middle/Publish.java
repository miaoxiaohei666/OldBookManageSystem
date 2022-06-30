package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.primarykey.PublishKey;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publish")
@IdClass(PublishKey.class)
public class Publish {

    @Id
    @Column(name = "uno", nullable = false)
    private Integer uno;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uno",insertable = false,updatable = false)
    private User user;

    @Id
    @Column(name = "bno", nullable = false)
    private Integer bno;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "bno",insertable = false,updatable = false)
    private Book book;

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }
}
