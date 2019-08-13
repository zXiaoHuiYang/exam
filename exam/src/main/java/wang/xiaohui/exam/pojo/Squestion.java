package wang.xiaohui.exam.pojo;

import javax.persistence.*;

@Entity
@Table(name = "squestion")
public class Squestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "sa")
    private String sa;

    @Column(name = "sb")
    private String sb;

    @Column(name = "sc")
    private String sc;

    @Column(name = "sd")
    private String sd;

    @Column(name = "answer")
    private String answer;

    @Column(name = "spid")
    private Integer spid;

    @Column(name = "doanswer")
    private String doanswer;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getDoanswer() {
        return doanswer;
    }

    public void setDoanswer(String doanswer) {
        this.doanswer = doanswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
