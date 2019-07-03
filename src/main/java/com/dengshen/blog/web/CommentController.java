package com.dengshen.blog.web;

import com.dengshen.blog.Actions.ActionResult;
import com.dengshen.blog.dao.CommentDao;
import com.dengshen.blog.pojo.Comment;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@Api(tags = "评论")
public class CommentController {


    @Autowired
    CommentDao commentDao;


    @PostMapping(value = "/comment")
    @ResponseBody
    public ActionResult createComment(@RequestBody Comment comment) {
        System.out.println(comment);
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
