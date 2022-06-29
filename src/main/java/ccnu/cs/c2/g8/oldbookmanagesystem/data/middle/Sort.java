package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
@Data
@Entity
@Table (name = "SORT")
@IdClass(PrimaryKey.class)
@DynamicUpdate
public class Sort {
    /**
     * &#064;description  主键
     */
    @Id
    @Column(name = "Sno",nullable = false)
    private Integer sno;

    /**
     * &#064;description  主键
     */
    @Column(name = "Sname",nullable = false)
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
