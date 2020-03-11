package com.subang.lost.service;

import com.subang.lost.dao.CollectDao;
import com.subang.lost.pojo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CollectService {
    @Autowired
    private CollectDao collectDao;
    
    @Autowired
    private IdWorker idWorker;
    
    public List<Collect> findAll(){
        return collectDao.findAll();
    }
    
    public Collect findById(String id){
        return collectDao.findById(id).get();
    }
    
    public void save(Collect collect){
        collect.setId(idWorker.nextId()+"");
        collectDao.save(collect);
    }
    
    public void updateById(Collect collect, String id){
        if (collectDao.findById(id).isPresent()){
            collectDao.save(collect);
        }else{
            throw new RuntimeException("该回复不存在");
        }
    }
    
    public void deleteById(String id){
        collectDao.deleteById(id);
    }
}
