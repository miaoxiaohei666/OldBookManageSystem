package ccnu.cs.c2.g8.oldbookmanagesystem.data.entity;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bno",nullable = false)
    private Integer bno;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "bno")
    private List<User> userList_toWant;

    @OneToMany(targetEntity = Publish.class)
    @JoinColumn(name = "bno")
    private List<User> userList_toPublish;
    @Column(name = "sno")
    private Integer sno;

    @ManyToOne(targetEntity = Sort.class)
    @JoinColumn(name = "sno",insertable = false,updatable = false)
    private Sort sort;
    @Column(name = "bname")
    private String bname;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "bpicture")
    private String bpicture;

    @Column(name = "bprice")
    private Double bprice;

    @Column(name = "bdescribe")
    private String bdescribe;

    @Column(name = "bstate")
    private boolean bstate;

    public Book() {
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getBpicture() {
        return bpicture;
    }

    public void setBpicture(String bpicture) {
        this.bpicture = bpicture;
    }

    public Double getBprice() {
        return bprice;
    }

    public void setBprice(Double bprice) {
        this.bprice = bprice;
    }

    public String getBdescribe() {
        return bdescribe;
    }

    public void setBdescribe(String bdescribe) {
        this.bdescribe = bdescribe;
    }

    public boolean isBstate() {
        return bstate;
    }

    public void setBstate(boolean bstate) {
        this.bstate = bstate;
    }
}
