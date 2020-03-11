package com.subang.article.dao;

import com.subang.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
}
