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
    private String uno;

    @Id
    @Column(name = "Bno")
    private String bno;

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }
}
