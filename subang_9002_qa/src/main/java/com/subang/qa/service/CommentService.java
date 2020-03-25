package com.subang.qa.service;

import com.subang.qa.dao.CommentDao;
import com.subang.qa.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

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

    public List<Comment> findAll(){
        return commentDao.findAll();
    }

    public Comment findById(String id) {
        Comment comment = (Comment) redisTemplate.opsForValue().get("qa_comment_"+id);
        if (comment == null){
            comment = commentDao.findById(id).get();
            redisTemplate.opsForValue().set("qa_comment_"+id, comment,1, TimeUnit.DAYS);
        }
        return comment;
    }

    public void save(Comment comment){
        comment.setId(idWorker.nextId()+"");
        commentDao.save(comment);
    }

    public void updateById(Comment comment, String id){
        if (commentDao.findById(id).isPresent()){
            commentDao.save(comment);
            redisTemplate.delete("qa_comment_"+id);
        }else{
            throw new RuntimeException("该评论不存在");
        }
    }

    public void deleteById(String id){
        redisTemplate.delete("qa_comment_"+id);
        commentDao.deleteById(id);
    }
}
