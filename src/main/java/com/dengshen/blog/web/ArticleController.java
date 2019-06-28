package com.dengshen.blog.web;

import com.dengshen.blog.Actions.ActionResult;
import com.dengshen.blog.dao.ArticleDAO;
import com.dengshen.blog.dao.CommentDao;
import com.dengshen.blog.pojo.Article;
import com.dengshen.blog.pojo.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "*")
@Api(tags = "文章")
public class ArticleController {

    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    CommentDao commentDao;

    @ApiOperation(value = "新增文章")
    @PostMapping("article")
    public ActionResult createArticle(
            @RequestParam(value = "title") @NotNull String title,
            @RequestParam(value = "content") String content
    ) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        articleDAO.save(article);

        ActionResult actionResult = new ActionResult();
        actionResult.setData(article);
        actionResult.setMsg("新增成功");
        actionResult.setSuccess(true);
        actionResult.setCode(200);
        return actionResult;
    }

    @ApiOperation(value = "通过ID删除文章")
    @DeleteMapping("article/{id}")
    public ActionResult deleteArticle(
            @PathVariable(value = "id") int id
    ) {
        Article article = new Article();
        article.setId(id);
        articleDAO.delete(article);
        ActionResult actionResult = new ActionResult();
        actionResult.setMsg("删除成功");
        actionResult.setSuccess(true);
        actionResult.setCode(200);
        return actionResult;
    }

    @ApiOperation(value = "分页获取文章")
    @GetMapping("articles")
    public ActionResult listArticle(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println("query all Ok");
        ActionResult actionResult = new ActionResult();
        actionResult.setSuccess(true);
        actionResult.setMsg("查询成功");
        actionResult.setCode(200);
        actionResult.setData(articleDAO.findAll());
        return actionResult;
    }

    @ApiOperation(value = "通过ID获取文章")
    @GetMapping("article/{id}")
    public ActionResult article(@PathVariable("id") int id) {
        System.out.println("query one Ok" + id);
        System.out.println(articleDAO.findById(id));
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(200);
        actionResult.setMsg("查询成功");
        actionResult.setSuccess(true);
        Map data = new HashMap();
        data.put("article", articleDAO.findById(id));
        List<Comment> comments = commentDao.findByArticleId(id);
        data.put("comments", comments);
        actionResult.setData(data);
        return actionResult;
    }
}
