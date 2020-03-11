package com.subang.lost.service;

import com.subang.lost.dao.CommentDao;
import com.subang.lost.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    public List<Comment> findAll(){
        return commentDao.findAll();
    }

    public Comment findById(String id){
        return commentDao.findById(id).get();
    }

    public void save(Comment comment){
        comment.setId(idWorker.nextId()+"");
        commentDao.save(comment);
    }

    public void updateById(Comment comment, String id){
        if (commentDao.findById(id).isPresent()){
            commentDao.save(comment);
        }else{
            throw new RuntimeException("该评论不存在");
        }
    }

    public void deleteById(String id){
        commentDao.deleteById(id);
    }
}
