package ccnu.cs.c2.g8.oldbookmanagesystem.data.vo;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class ViewBook_toAdmin {
    @Id
    @Column(name = "bno")
    private Integer bno;

    @Column(name = "sno")
    private Integer sno;

    @Column(name = "bname")
    private String bname;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "bpicture")
    private String bpicture;

    @Column(name = "bprice")
    private Double bprice;

    @Column(name = "bdescibe")
    private String bdescibe;

    @Column(name = "bstate")
    private boolean bstate;

    @OneToMany(targetEntity = Publish.class)
    @JoinColumn(name = "bno")
    private List<User> publishList;

    @ManyToOne(targetEntity = Sort.class)
    @JoinColumn(name = "sno",insertable = false,updatable = false)
    private Sort sort;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "bno")
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

    public List<User> getPublishList() {
        return publishList;
    }

    public void setPublishList(List<User> userList) {
        this.publishList = userList;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<User> getWantList() {
        return wantList;
    }

    public void setWantList(List<User> wantList) {
        this.wantList = wantList;
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
