package com.subang.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_signup")
public class Signup implements Serializable {
    @Id
    private String id;
    private String userid;
    private String voteid;
    private String selectionid;

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

    public String getVoteid() {
        return voteid;
    }

    public void setVoteid(String voteid) {
        this.voteid = voteid;
    }

    public String getSelectionid() {
        return selectionid;
    }

    public void setSelectionid(String selectionid) {
        this.selectionid = selectionid;
    }
}
