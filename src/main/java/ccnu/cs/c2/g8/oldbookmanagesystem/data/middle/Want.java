package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;


@Entity
@Table(name = "WANT")
@IdClass(PrimaryKey.class)
@DynamicUpdate
public class Want {
    /**
     * &#064;description  主键
     */
    @Id
    @Column(name = "Bno",nullable = false)
    private Integer bno;
    /**
     * &#064;description  主键
     */
    @Id
    @Column(name = "Uno",nullable = false)
    private Integer uno;

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
