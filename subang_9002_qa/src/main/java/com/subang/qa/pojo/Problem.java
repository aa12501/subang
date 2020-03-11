package com.subang.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_problem")
public class Problem implements Serializable {
    @Id
    private String id;
    private String userid;
    private String usernickname;
    private Integer anonymous;
    private Integer solve;
    private Integer state;
    private String statemsg;
    private String labelid;
    private String title;
    private String content;
    private Date createtime;
    private Date modifiedtime;
    private Long thumbupcount;
    private Long replycount;
    private Long visitcount;
    private Long carecount;

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

    public Integer getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Integer anonymous) {
        this.anonymous = anonymous;
    }

    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
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

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
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

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Long getThumbupcount() {
        return thumbupcount;
    }

    public void setThumbupcount(Long thumbupcount) {
        this.thumbupcount = thumbupcount;
    }

    public Long getReplycount() {
        return replycount;
    }

    public void setReplycount(Long replycount) {
        this.replycount = replycount;
    }

    public Long getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Long visitcount) {
        this.visitcount = visitcount;
    }

    public Long getCarecount() {
        return carecount;
    }

    public void setCarecount(Long carecount) {
        this.carecount = carecount;
    }
}
