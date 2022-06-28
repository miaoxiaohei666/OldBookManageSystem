package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLISH")
public class Publish {
    @Id
    @Column(name = "Uno")
    private Integer uno;

    @Id
    @Column(name = "Bno")
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
