package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "SORT")
public class Sort {
    @Id
    @Column(name = "Sno")
    private Integer sno;

    @Column(name = "Sname")
    private String sname;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
