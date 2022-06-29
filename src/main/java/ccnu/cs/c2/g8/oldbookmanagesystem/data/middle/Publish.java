package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.PrimaryKey.PublishKey;
import javax.persistence.*;

@Entity
@Table(name = "PUBLISH")
@IdClass(PublishKey.class)
public class Publish {

    @Id
    @Column(name = "Uno",nullable = false)
    private Integer uno;

    @Id
    @Column(name = "Bno",nullable = false)
    private Integer bno;

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
