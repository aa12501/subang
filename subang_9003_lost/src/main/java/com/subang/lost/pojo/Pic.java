package com.subang.lost.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_pic")
public class Pic implements Serializable {
    @Id
    private String id;
    private String state;
    private String statemsg;
    private String base64;
    private String lostid;
    private Integer index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatemsg() {
        return statemsg;
    }

    public void setStatemsg(String statemsg) {
        this.statemsg = statemsg;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getLostid() {
        return lostid;
    }

    public void setLostid(String lostid) {
        this.lostid = lostid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
