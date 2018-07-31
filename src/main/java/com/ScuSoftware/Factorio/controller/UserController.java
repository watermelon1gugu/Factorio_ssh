package com.ScuSoftware.Factorio.controller;

import com.ScuSoftware.Factorio.dto.LoginRequest;
import com.ScuSoftware.Factorio.dto.testRequest;
import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.service.MemberService;
import com.sun.xml.internal.bind.v2.TODO;
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
    private final MemberService memberService;

    @Autowired
    public UserController(UserService userService, MemberService memberService) {
        this.userService = userService;
        this.memberService = memberService;
    }
//TODO 改为ControllerAdvice
    @PostMapping(value = "register")
    public Response register(@RequestBody RegisterRequest registerRequest, HttpSession session) {
            registerRequest.print();
        if (session.getAttribute("_code") != null && session.getAttribute("_code").equals(registerRequest.getCheckCode())) {
            User user = registerRequest.formatToUser();
            Member member = registerRequest.formatToMember();
                try {
                    userService.register(user,member);
                    return new Response<>(200, "注册成功");
                }catch (Exception e){
                    return new Response<>(500, "注册失败");
                }
        } else return new Response<>(501, "验证码错误");
    }

    @PostMapping(value = "login")
    public Response login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        if (session.getAttribute("_code") != null && session.getAttribute("_code").equals(loginRequest.getCheckCode())) {
            User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            if (user != null) {
                return new Response<>(200, user);
            } else {
                return new Response<>(500, "登录邮箱或密码错误");
            }
        } else return new Response<>(501, "验证码错误");
    }

    @GetMapping(value = "authCode")
    public void getAuthCode(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String verifyCode = RandomStringUtils.randomNumeric(4);
        session.setAttribute("_code", verifyCode);
        VerifyCodeUtils.outputImage(80, 50, response.getOutputStream(), verifyCode);
    }

}


