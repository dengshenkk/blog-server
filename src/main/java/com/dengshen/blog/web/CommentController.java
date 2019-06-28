package com.dengshen.blog.web;

import com.dengshen.blog.Actions.ActionResult;
import com.dengshen.blog.dao.CommentDao;
import com.dengshen.blog.pojo.Article;
import com.dengshen.blog.pojo.Comment;
import io.swagger.annotations.Api;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*.**")
@Api(tags = "评论")
public class CommentController {


    @Autowired
    CommentDao commentDao;


    @PostMapping(value = "/comment")
    public ActionResult createComment(
            @RequestParam(value = "articleId") @NotNull int articleId,
            @RequestParam(value = "userName") @NotNull String userName,
            @RequestParam(value = "commentContent") @NotNull String content,
            @RequestParam(value = "email") @NotNull String email
            ) {
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setCommentContent(content);
        comment.setEmail(email);
        comment.setUserName(userName);
        commentDao.save(comment);
        ActionResult actionResult = new ActionResult();
        actionResult.setSuccess(true);
        actionResult.setCode(200);
        actionResult.setMsg("评论成功");
        actionResult.setData(comment);
        return actionResult;
    }

    @GetMapping(value = "/comments")
    public List<Comment> getComments() {
        return commentDao.findAll();
    }
}
