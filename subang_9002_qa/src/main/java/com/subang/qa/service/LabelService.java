package com.subang.qa.service;

import com.subang.qa.dao.LabelDao;
import com.subang.qa.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void updateById(Label label, String id){
        if (labelDao.findById(id).isPresent()){
            labelDao.save(label);
        }else{
            throw new RuntimeException("该问题不存在");
        }
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }
}
