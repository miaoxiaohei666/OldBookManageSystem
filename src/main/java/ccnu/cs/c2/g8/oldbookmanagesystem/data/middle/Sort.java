package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table (name = "SORT")
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sno",nullable = false)
    private Integer sno;

    @Column(name = "Sgrade")
    private String sgrade;

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
