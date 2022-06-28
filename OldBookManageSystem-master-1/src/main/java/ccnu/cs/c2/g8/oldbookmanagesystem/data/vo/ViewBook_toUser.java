package ccnu.cs.c2.g8.oldbookmanagesystem.data.vo;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.user;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ViewBook_toUser")
public class ViewBook_toUser {
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
    private List<user> publishList;

    @ManyToOne(targetEntity = Sort.class)
    @JoinColumn(name = "Sno")
    private Sort sort;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "Bno")
    private List<user> wantList;


    public ViewBook_toUser() {
    }

    public ViewBook_toUser(Book book) {
        setBno(book.getBno());
        setSno(book.getSno());
        setBname(book.getBname());
        book.getCreate_time();
        setBpicture(book.getBpicture());
        setBprice(book.getBprice());
        setBdescibe(book.getBdescibe());
        setBstate(book.isBstate());
    }

    public List<user> getPublishList() {
        return publishList;
    }

    public void setPublishList(List<user> userList) {
        this.publishList = userList;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<user> getWantList() {
        return wantList;
    }

    public void setWantList(List<user> wantList) {
        this.wantList = wantList;
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

    public String getCreate_time(){
        setCreate_time();
        return create_time;
    }
    public void setCreate_time(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_time = formatter.format(date);
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