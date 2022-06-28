package ccnu.cs.c2.g8.oldbookmanagesystem.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bno")
    private Integer bno;

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
