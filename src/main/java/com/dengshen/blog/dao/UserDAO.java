package com.dengshen.blog.dao;

import com.dengshen.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface UserDAO extends JpaRepository<User, Integer> {
}
