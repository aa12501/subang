package com.subang.activity.service;

import com.subang.activity.dao.PicDao;
import com.subang.activity.pojo.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class PicService {
    @Autowired
    private PicDao picDao;

    @Autowired
    private IdWorker idWorker;

    public List<Pic> findAll(){
        return picDao.findAll();
    }

    public Pic findById(String id){
        return picDao.findById(id).get();
    }

    public void save(Pic pic){
        pic.setId(idWorker.nextId()+"");
        picDao.save(pic);
    }

    public void updateById(Pic pic, String id){
        if (picDao.findById(id).isPresent()){
            picDao.save(pic);
        }else{
            throw new RuntimeException("该图片不存在");
        }
    }

    public void deleteById(String id){
        picDao.deleteById(id);
    }
}
