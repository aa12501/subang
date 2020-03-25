package com.subang.qa.service;

import com.subang.qa.dao.CareDao;
import com.subang.qa.pojo.Care;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CareService {
    @Autowired
    private CareDao careDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Care> findAll(){
        return careDao.findAll();
    }

    public Care findById(String id){
        Care care = (Care) redisTemplate.opsForValue().get("qa_care_"+id);
        if (care == null){
            care = careDao.findById(id).get();
            redisTemplate.opsForValue().set("qa_care_"+id, care);
        }
        return care;
    }

    public void save(Care comment){
        comment.setId(idWorker.nextId()+"");
        careDao.save(comment);
    }

    public void deleteById(String id){
        redisTemplate.delete("qa_care_"+id);
        careDao.deleteById(id);
    }
}
