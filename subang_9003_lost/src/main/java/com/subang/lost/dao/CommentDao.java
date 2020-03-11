package com.subang.lost.dao;

import com.subang.lost.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentDao extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment> {
}
