package ccnu.cs.c2.g8.oldbookmanagesystem.data.vo;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table (name = "users")
public class VIewUser_toUser {
    @Id
    @Column(name = "uno")
    private int uno;

    @Column(name = "ugrade")
    private Integer ugrade;

    @Column(name = "uname")
    private String uname;

    @Column(name = "unickname")
    private String unickname;

    @Column(name = "utel")
    private BigInteger utel;

    @Column(name = "uwechat")
    private String uwechat;

    @Column(name = "uqq")
    private String uqq;

    @Column(name = "upassword")
    private String upassword;

    @Column(name = "ulike")
    private Integer like;

    @Column(name = "unlike")
    private Integer unlike;

    @OneToMany(targetEntity = Publish.class)
    @JoinColumn(name = "uno")
    private List<Book> publishList;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "uno")
    private List<Book> wantList;

    public VIewUser_toUser() {
    }

    public VIewUser_toUser(User user) {
        setUno(user.getUno());
        setUgrade(user.getUgrade());
        setUname(user.getUname());
        setUnickname(user.getUnickname());
        setUtel(user.getUtel());
        setUwechat(user.getUwechat());
        setUqq(user.getUqq());
        setUpassword(user.getUpassword());
        setLike(user.getLike());
        setUnlike(user.getUnlike());
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public List<Book> getPublishList() {
        return publishList;
    }

    public void setPublishList(List<Book> bookList) {
        this.publishList = bookList;
    }

    public List<Book> getWantList() {
        return wantList;
    }

    public void setWantList(List<Book> wantList) {
        this.wantList = wantList;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public Integer getUgrade() {
        return ugrade;
    }

    public void setUgrade(Integer ugrade) {
        this.ugrade = ugrade;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public BigInteger getUtel() {
        return utel;
    }

    public void setUtel(BigInteger utel) {
        this.utel = utel;
    }

    public String getUwechat() {
        return uwechat;
    }

    public void setUwechat(String uwechat) {
        this.uwechat = uwechat;
    }

    public String getUqq() {
        return uqq;
    }

    public void setUqq(String uqq) {
        this.uqq = uqq;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getUnlike() {
        return unlike;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }
}
