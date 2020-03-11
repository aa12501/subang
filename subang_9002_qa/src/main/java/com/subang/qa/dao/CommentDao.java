package com.subang.qa.dao;

import com.subang.qa.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentDao extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment> {
}
