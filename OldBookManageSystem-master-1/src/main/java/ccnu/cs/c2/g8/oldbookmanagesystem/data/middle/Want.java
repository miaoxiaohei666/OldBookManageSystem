package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WANT")
public class Want {
    @Id
    @Column(name = "Bno")
    private String bno;

    @Id
    @Column(name = "Uno")
    private String uno;

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }
}
