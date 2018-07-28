package com.ScuSoftware.Factorio.controller;
import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import com.ScuSoftware.Factorio.dto.RegisterRequest;
import com.ScuSoftware.Factorio.dto.Response;
import com.ScuSoftware.Factorio.service.UserService;
import com.ScuSoftware.Factorio.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "get")
    public String getUsers() {
        return "Hello Spring Security";
    }

    @PostMapping(value = "register")
    public Response register(@RequestBody RegisterRequest registerRequest, HttpSession session) {
        if(session.getAttribute("_code")!=null&&session.getAttribute("_code").equals(registerRequest.getCheckCode())){
            User user = registerRequest.formatToUser();

            return new Response(200,"注册成功");
        }else return new Response(500,"请输入验证码");
    }
    @RequestMapping(value = "authCode", method = RequestMethod.GET)
    public void getAuthCode(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String verifyCode = RandomStringUtils.randomNumeric(4);
        session.setAttribute("_code", verifyCode);
        VerifyCodeUtils.outputImage(80, 50, response.getOutputStream(), verifyCode);
    }

}


