package com.subang.vote.service;

import com.subang.vote.dao.VoteDao;
import com.subang.vote.pojo.Vote;
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
public class VoteService {
    @Autowired
    private VoteDao voteDao;

    @Autowired
    private IdWorker idWorker;

    public List<Vote> findAll() {
        return voteDao.findAll();
    }

    public Vote findById(String id) {
        return voteDao.findById(id).get();
    }

    public void save(Vote vote) {
        vote.setId(idWorker.nextId() + "");
        voteDao.save(vote);
    }

    public void updateById(Vote vote, String id) {
        if (voteDao.findById(id).isPresent()) {
            voteDao.save(vote);
        }else{
            throw new RuntimeException("该文章不存在");
        }
    }

    public void deleteById(String id){
        voteDao.deleteById(id);
    }

    public List<Vote> findSearch(Vote vote){
        return voteDao.findAll((Specification<Vote>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (vote.getUsernickname() != null && !"".equals(vote.getUsernickname())){
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + vote.getUsernickname() + "%");
                list.add(predicate);
            }
            if (vote.getTitle() != null && !"".equals(vote.getTitle())){
                Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + vote.getTitle() + "%");
                list.add(predicate);
            }
            if (vote.getContent() != null && !"".equals(vote.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + vote.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        });
    }

    public Page<Vote> findSearchByPage(Vote vote, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return voteDao.findAll((Specification<Vote>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (vote.getUsernickname() != null && !"".equals(vote.getUsernickname())){
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + vote.getUsernickname() + "%");
                list.add(predicate);
            }
            if (vote.getTitle() != null && !"".equals(vote.getTitle())){
                Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + vote.getTitle() + "%");
                list.add(predicate);
            }
            if (vote.getContent() != null && !"".equals(vote.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + vote.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        }, pageable);
    }

}
