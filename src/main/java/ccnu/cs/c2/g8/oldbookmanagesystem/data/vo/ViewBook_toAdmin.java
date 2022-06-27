package ccnu.cs.c2.g8.oldbookmanagesystem.data.vo;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ViewBook_toAdmin")
public class ViewBook_toAdmin {
    @Id
    @Column(name = "Bno")
    private String bno;

    @Column(name = "Sno")
    private Integer sno;

    @Column(name = "Bname")
    private String bname;

    @Column(name = "Create_time")
    private String create_time;

    @Column(name = "Bpicture")
    private String bpicture;

    @Column(name = "Bprice")
    private Double bprice;

    @Column(name = "Bdescibe")
    private String bdescibe;

    @Column(name = "Bstate")
    private boolean bstate;

    @OneToMany(targetEntity = Publish.class)
    @JoinColumn(name = "Bno")
    private List<User> userList;

    @ManyToOne(targetEntity = Sort.class)
    @JoinColumn(name = "Sno")
    private Sort sort;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "Bno")
    private List<User> wantList;


    public ViewBook_toAdmin() {
    }
    public ViewBook_toAdmin(Book book) {
        setBno(book.getBno());
        setSno(book.getSno());
        setBname(book.getBname());
        setCreate_time(book.getCreate_time());
        setBpicture(book.getBpicture());
        setBprice(book.getBprice());
        setBdescibe(book.getBdescibe());
        setBstate(book.isBstate());
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
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

    public String getBdescibe() {
        return bdescibe;
    }

    public void setBdescibe(String bdescibe) {
        this.bdescibe = bdescibe;
    }

    public boolean isBstate() {
        return bstate;
    }

    public void setBstate(boolean bstate) {
        this.bstate = bstate;
    }
}
