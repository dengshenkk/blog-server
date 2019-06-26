package com.dengshen.blog;

import com.dengshen.blog.dao.ArticleDAO;
import com.dengshen.blog.pojo.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleDAO articleDAO;

    @Test
    public void addArticleTest() {
        Article article = new Article();
        article.setTitle("title" + 1);
        article.setContent("content" + 1);
        article.toString();
    }
}
