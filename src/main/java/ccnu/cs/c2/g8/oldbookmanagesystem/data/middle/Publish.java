package ccnu.cs.c2.g8.oldbookmanagesystem.data.middle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISH")
@IdClass(PrimaryKey.class)
@DynamicUpdate
public class Publish {
    /**
     * &#064;description  主键
     */
    @Id
    @Column(name = "Uno",nullable = false)
    private Integer uno;
    /**
     * &#064;description  主键
     */
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
