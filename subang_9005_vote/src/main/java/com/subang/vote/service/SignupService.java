package com.subang.vote.service;

import com.subang.vote.dao.SignupDao;
import com.subang.vote.pojo.Signup;
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

    public void save(Signup signup){
        signup.setId(idWorker.nextId()+"");
        signupDao.save(signup);
    }

    public void updateById(Signup signup, String id){
        if (signupDao.findById(id).isPresent()){
            signupDao.save(signup);
        }else{
            throw new RuntimeException("不存在");
        }
    }

    public void deleteById(String id){
        signupDao.deleteById(id);
    }
}
