package com.subang.activity.service;

import com.subang.activity.dao.SignupDao;
import com.subang.activity.pojo.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class SignupService {
    @Autowired
    private SignupDao signupDao;

    @Autowired
    private IdWorker idWorker;

    public List<Signup> findAll(){
        return signupDao.findAll();
    }

    public Signup findById(String id){
        return signupDao.findById(id).get();
    }

    public void save(Signup activity){
        activity.setId(idWorker.nextId()+"");
        signupDao.save(activity);
    }

    public void updateById(Signup activity, String id){
        if (signupDao.findById(id).isPresent()){
            signupDao.save(activity);
        }else{
            throw new RuntimeException("不存在");
        }
    }

    public void deleteById(String id){
        signupDao.deleteById(id);
    }
}
