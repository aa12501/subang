package com.subang.article.service;

import com.subang.article.dao.CommentDao;
import com.subang.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public Comment findById(String id) {
        Comment comment = (Comment) redisTemplate.opsForValue().get("article_comment_" + id);
        if (comment == null) {
            comment = commentDao.findById(id).get();
            redisTemplate.opsForValue().set("article_comment_" + id, comment, 1, TimeUnit.DAYS);
        }
        return comment;
    }

    public void save(Comment comment) {
        comment.setId(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    public void updateById(Comment comment, String id) {
        if (commentDao.findById(id).isPresent()) {
            redisTemplate.delete("article_comment_" + id);
            commentDao.save(comment);
        } else {
            throw new RuntimeException("该评论不存在");
        }
    }

    public void deleteById(String id) {
        redisTemplate.delete("article_comment_" + id);
        commentDao.deleteById(id);
    }

    public List<Comment> findSearch(Comment comment) {
        return commentDao.findAll((Specification<Comment>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (comment.getUsernickname() != null && !"".equals(comment.getUsernickname())) {
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + comment.getUsernickname() + "%");
                list.add(predicate);
            }
            if (comment.getContent() != null && !"".equals(comment.getContent())) {
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + comment.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        });
    }

    public Page<Comment> findSearchByPage(Comment comment, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return commentDao.findAll((Specification<Comment>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (comment.getUsernickname() != null && !"".equals(comment.getUsernickname())) {
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + comment.getUsernickname() + "%");
                list.add(predicate);
            }
            if (comment.getContent() != null && !"".equals(comment.getContent())) {
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + comment.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        }, pageable);
    }

}
