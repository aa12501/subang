package com.subang.lost.service;

import com.subang.lost.dao.LostDao;
import com.subang.lost.pojo.Lost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class LostService {
    @Autowired
    private LostDao lostDao;

    @Autowired
    private IdWorker idWorker;

    public List<Lost> findAll(){
        return lostDao.findAll();
    }

    public Lost findById(String id){
        return lostDao.findById(id).get();
    }

    public void save(Lost lost){
        lost.setId(idWorker.nextId()+"");
        lostDao.save(lost);
    }

    public void updateById(Lost lost, String id){
        if (lostDao.findById(id).isPresent()){
            lostDao.save(lost);
        }else{
            throw new RuntimeException("该问题不存在");
        }
    }

    public void deleteById(String id){
        lostDao.deleteById(id);
    }
}
