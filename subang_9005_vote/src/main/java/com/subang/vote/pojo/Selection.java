package com.subang.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_selection")
public class Selection implements Serializable {
    @Id
    private String id;
    private String content;
    private String voteid;
    private Long signupcount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVoteid() {
        return voteid;
    }

    public void setVoteid(String voteid) {
        this.voteid = voteid;
    }

    public Long getSignupcount(){
        return signupcount;
    }

    public void setSignupcount(Long signupcount){
        this.signupcount = signupcount;
    }
}
