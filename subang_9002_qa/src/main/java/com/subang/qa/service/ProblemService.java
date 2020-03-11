package com.subang.qa.service;

import com.subang.qa.dao.ProblemDao;
import com.subang.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ProblemService {
    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private IdWorker idWorker;

    public List<Problem> findAll(){
        return problemDao.findAll();
    }

    public Problem findById(String id){
        return problemDao.findById(id).get();
    }

    public void save(Problem problem){
        problem.setId(idWorker.nextId()+"");
        problemDao.save(problem);
    }

    public void updateById(Problem problem, String id){
        if (problemDao.findById(id).isPresent()){
            problemDao.save(problem);
        }else{
            throw new RuntimeException("该问题不存在");
        }
    }

    public void deleteById(String id){
        problemDao.deleteById(id);
    }
}
