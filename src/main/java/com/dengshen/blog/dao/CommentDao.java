package com.dengshen.blog.dao;

import com.dengshen.blog.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    public List<Comment> findByArticleId(int id);
}
