package com.subang.activity.service;

import com.subang.activity.dao.LabelDao;
import com.subang.activity.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void updateById(Label label, String id) {
        if (labelDao.findById(id).isPresent()) {
            labelDao.save(label);
        }else{
            throw new RuntimeException("该标签不存在");
        }
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label){
        return labelDao.findAll((Specification<Label>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (label.getName() != null && !"".equals(label.getName())){
                Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + label.getName() + "%");
                list.add(predicate);
            }
            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        });
    }

    public Page<Label> findSearchByPage(Label label, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll((Specification<Label>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (label.getName() != null && !"".equals(label.getName())){
                Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + label.getName() + "%");
                list.add(predicate);
            }
            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        }, pageable);
    }

}
