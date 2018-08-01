package com.ScuSoftware.Factorio;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.ScuSoftware.Factorio.dao.CommentsMapper;
import com.ScuSoftware.Factorio.dao.MemberMapper;
import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.dto.RegisterRequest;
import com.ScuSoftware.Factorio.dto.Response;
import com.ScuSoftware.Factorio.model.Comments;
import com.ScuSoftware.Factorio.model.CommentsExample;
import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FactorioApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private CommentsMapper commentsMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private UserMapper userMapper;
	@Transactional
	public int test(){
		Member member = new Member();
		member = memberMapper.selectByPrimaryKey("2016141502067");
		Comments comments = new Comments();
		comments.setCommentsDate(new Date());
		comments.setUserId(123141);
		comments.setTitle("w1w1w1");
		comments.setContent("我我我我");
		System.out.println("This is");
		try {
			return commentsMapper.insert(comments) * memberMapper.insert(member);
		}catch (Exception e){
			throw e;
		}
	}
	@Test
	public void contextLoads() {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail("843874092@qq.com");
		registerRequest.setisMember(true);
		registerRequest.setName("陈益");
		registerRequest.setNickName("西瓜");
		registerRequest.setPassword("chenyi456");
		registerRequest.setStudentID("2016141502067");
		registerRequest.setSex(true);
		User user = registerRequest.formatToUser();
		Member member = registerRequest.formatToMember();
		try {
			userService.register(user,member);
            userService.register(user,member);
			System.out.println("sssssssssssssss");

		}catch (RuntimeException e){
			System.out.println("Message:");
			System.out.println(e.getMessage());

		}
	}


}
