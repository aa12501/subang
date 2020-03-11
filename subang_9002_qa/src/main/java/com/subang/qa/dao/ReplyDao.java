package com.subang.qa.dao;

import com.subang.qa.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReplyDao extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {
}
