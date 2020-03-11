package com.subang.activity.service;

import com.subang.activity.dao.ActivityDao;
import com.subang.activity.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private IdWorker idWorker;

    public List<Activity> findAll(){
        return activityDao.findAll();
    }

    public Activity findById(String id){
        return activityDao.findById(id).get();
    }

    public void save(Activity activity){
        activity.setId(idWorker.nextId()+"");
        activityDao.save(activity);
    }

    public void updateById(Activity activity, String id){
        if (activityDao.findById(id).isPresent()){
            activityDao.save(activity);
        }else{
            throw new RuntimeException("该问题不存在");
        }
    }

    public void deleteById(String id){
        activityDao.deleteById(id);
    }
}
