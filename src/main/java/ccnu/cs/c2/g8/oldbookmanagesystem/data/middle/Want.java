package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.primarykey.WantKey;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@Table(name = "want")
@IdClass(WantKey.class)
@DynamicUpdate
public class Want {
    @Id
    @Column(name = "bno", nullable = false)
    private Integer bno;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "bno",insertable = false,updatable = false)
    private Book book;

    @Id
    @Column(name = "uno", nullable = false)
    private Integer uno;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uno",insertable = false,updatable = false)
    private User user;

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }
}
