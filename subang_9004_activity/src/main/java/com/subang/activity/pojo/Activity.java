package com.subang.activity.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_activity")
public class Activity implements Serializable {
    @Id
    private String id;
    private String userid;
    private String usernickname;
    private Integer solve;
    private Integer state;
    private String statemsg;
    private String title;
    private String content;
    private String area;
    private String labelid;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    public Integer getNeedcount() {
        return needcount;
    }

    public void setNeedcount(Integer needcount) {
        this.needcount = needcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    private Integer needcount;
    private Date starttime;
    private Date endtime;
    private Date createtime;
    private Date modifiedtime;
    private Long signupcount;
    private Long visitcount;
}