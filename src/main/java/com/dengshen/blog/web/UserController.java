package com.dengshen.blog.web;

import com.dengshen.blog.Actions.ActionResult;
import com.dengshen.blog.dao.UserDAO;
import com.dengshen.blog.pojo.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin(value = "*")
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostMapping(value = "/user")
    public ActionResult createUser(
            @RequestParam(value = "userName") @NotNull String userName,
            @RequestParam(value = "password") @NotNull String password,
            @RequestParam(value = "email") @Email String email,
            @RequestParam(value = "phone") @NotNull String phone
    ) {
        String phone1 = phone;
        User user = new User();
        ActionResult actionResult = new ActionResult();
        try {
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);
            userDAO.save(user);

            actionResult.setMsg("创建成功");
            actionResult.setCode(200);
            actionResult.setSuccess(true);
            actionResult.setData(user);
        } catch (Exception e) {
            actionResult.setMsg("创建失败" + e.toString());
            actionResult.setCode(400);
            actionResult.setSuccess(true);
            actionResult.setData(user);
        }

        return actionResult;
    }
}
