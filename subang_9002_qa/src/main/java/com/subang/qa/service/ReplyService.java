package com.subang.qa.service;

import com.subang.qa.dao.ReplyDao;
import com.subang.qa.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ReplyService {
    @Autowired
    private ReplyDao replyDao;
    
    @Autowired
    private IdWorker idWorker;
    
    public List<Reply> findAll(){
        return replyDao.findAll();
    }
    
    public Reply findById(String id){
        return replyDao.findById(id).get();
    }
    
    public void save(Reply reply){
        reply.setId(idWorker.nextId()+"");
        replyDao.save(reply);
    }
    
    public void updateById(Reply reply, String id){
        if (replyDao.findById(id).isPresent()){
            replyDao.save(reply);
        }else{
            throw new RuntimeException("该回复不存在");
        }
    }
    
    public void deleteById(String id){
        replyDao.deleteById(id);
    }
}
