package com.subang.article.service;

import com.subang.article.dao.ArticleDao;
import com.subang.article.pojo.Article;
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
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public List<Article> findAll() {
        return articleDao.findAll();
    }

    public Article findById(String id) {
        return articleDao.findById(id).get();
    }

    public void save(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.save(article);
    }

    public void updateById(Article article, String id) {
        if (articleDao.findById(id).isPresent()) {
            articleDao.save(article);
        }else{
            throw new RuntimeException("该文章不存在");
        }
    }

    public void deleteById(String id){
        articleDao.deleteById(id);
    }

    public List<Article> findSearch(Article article){
        return articleDao.findAll((Specification<Article>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (article.getUsernickname() != null && !"".equals(article.getUsernickname())){
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + article.getUsernickname() + "%");
                list.add(predicate);
            }
            if (article.getTitle() != null && !"".equals(article.getTitle())){
                Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + article.getTitle() + "%");
                list.add(predicate);
            }
            if (article.getContent() != null && !"".equals(article.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + article.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        });
    }

    public Page<Article> findSearchByPage(Article article, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return articleDao.findAll((Specification<Article>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (article.getUsernickname() != null && !"".equals(article.getUsernickname())){
                Predicate predicate = criteriaBuilder.like(root.get("usernickname").as(String.class), "%" + article.getUsernickname() + "%");
                list.add(predicate);
            }
            if (article.getTitle() != null && !"".equals(article.getTitle())){
                Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + article.getTitle() + "%");
                list.add(predicate);
            }
            if (article.getContent() != null && !"".equals(article.getContent())){
                Predicate predicate = criteriaBuilder.like(root.get("content").as(String.class), "%" + article.getContent() + "%");
                list.add(predicate);
            }

            Predicate[] parr = new Predicate[list.size()];
            list.toArray(parr);
            return criteriaBuilder.and(parr);
        }, pageable);
    }

}
