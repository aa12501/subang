package com.subang.vote.service;

import com.subang.vote.dao.SelectionDao;
import com.subang.vote.pojo.Selection;
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
public class SelectionService {
    @Autowired
    private SelectionDao selectionDao;

    @Autowired
    private IdWorker idWorker;

    public List<Selection> findAll() {
        return selectionDao.findAll();
    }

    public Selection findById(String id) {
        return selectionDao.findById(id).get();
    }

    public void save(Selection selection) {
        selection.setId(idWorker.nextId() + "");
        selectionDao.save(selection);
    }

    public void updateById(Selection selection, String id) {
        if (selectionDao.findById(id).isPresent()) {
            selectionDao.save(selection);
        }else{
            throw new RuntimeException("该标签不存在");
        }
    }

    public void deleteById(String id){
        selectionDao.deleteById(id);
    }

    public List<Selection> findSearch(Selection selection){
        return selectionDao.findAll((Specification<Selection>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (selection.getContent() != null && !"".equals(selection.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + selection.getContent() + "%");
                list.add(predicate);
            }
            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        });
    }

    public Page<Selection> findSearchByPage(Selection selection, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return selectionDao.findAll((Specification<Selection>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (selection.getContent() != null && !"".equals(selection.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + selection.getContent() + "%");
                list.add(predicate);
            }
            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        }, pageable);
    }

}
