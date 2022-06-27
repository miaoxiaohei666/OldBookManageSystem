package ccnu.cs.c2.g8.oldbookmanagesystem.data.vo;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "VIewUser_toUser")
public class VIewUser_toUser {
    @Id
    @Column(name = "Uno")
    private Integer uno;

    @Column(name = "Ugrade")
    private Integer ugrade;

    @Column(name = "Uname")
    private String uname;

    @Column(name = "Unickname")
    private String unickname;

    @Column(name = "Utel")
    private String utel;

    @Column(name = "Uwechat")
    private String uwechat;

    @Column(name = "Uqq")
    private String uqq;

    @Column(name = "Upassword")
    private String upassword;

    @Column(name = "Like")
    private Integer like;

    @Column(name = "Unlike")
    private Integer unlike;

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
