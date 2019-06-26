package com.dengshen.blog.dao;

import com.dengshen.blog.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// 配合spring-data-rest 依赖自动生成RESTful风格 @RepositoryRestResource
public interface ArticleDAO extends JpaRepository<Article, Integer> {

}
