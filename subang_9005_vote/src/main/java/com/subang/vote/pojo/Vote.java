package com.subang.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_vote")
public class Vote implements Serializable {
    @Id
    private String id;
    private String userid;
    private String usernickname;
    private Integer state;
    private String statemsg;
    private String title;
    private String content;
    private Date createtime;
    private Long signupcount;
    private Long visitcount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStatemsg() {
        return statemsg;
    }

    public void setStatemsg(String statemsg) {
        this.statemsg = statemsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getSignupcount() {
        return signupcount;
    }

    public void setSignupcount(Long signupcount) {
        this.signupcount = signupcount;
    }

    public Long getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Long visitcount) {
        this.visitcount = visitcount;
    }
}
