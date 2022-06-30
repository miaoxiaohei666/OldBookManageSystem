package ccnu.cs.c2.g8.oldbookmanagesystem.data.entity;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Publish;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Want;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "uno",nullable = false)
    private Integer uno;

    @OneToMany(targetEntity = Want.class)
    @JoinColumn(name = "uno")
    private List<Book> bookList_toWant;

    @OneToMany(targetEntity = Publish.class)
    @JoinColumn(name = "uno")
    private List<Book> bookList_toPublish;
    @Column(name = "ugrade")
    private Integer ugrade;

    @Column(name = "uname")
    private String uname;


    @Column(name = "unickname")
    private String unickname;

    @Column(name = "utel")
    private String utel;

    @Column(name = "uwechat")
    private String uwechat;

    @Column(name = "uqq")
    private String uqq;

    @Column(name = "upassword")
    private String upassword;

    @Column(name = "ustate")
    private boolean ustate;

    @Column(name = "ulike")
    private Integer like;

    @Column(name = "unlike")
    private Integer unlike;

    public User() {
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

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
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

    public boolean isUstate() {
        return ustate;
    }

    public void setUstate(boolean ustate) {
        this.ustate = ustate;
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
