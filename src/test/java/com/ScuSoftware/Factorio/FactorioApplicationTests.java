package com.ScuSoftware.Factorio;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.ScuSoftware.Factorio.dao.CommentsMapper;
import com.ScuSoftware.Factorio.dao.MemberMapper;
import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.dto.RegisterRequest;
import com.ScuSoftware.Factorio.dto.Response;
import com.ScuSoftware.Factorio.model.*;
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

	@Test
	public void contextLoads() {
		/*UserExample userExample = new UserExample();
		UserExample.Criteria cri = userExample.createCriteria();*/
		String email = "843874092@qq.com";
		String password = "chenyi456";
/*		cri.andEmailEqualTo(email);
		cri.andPasswordEqualTo(password);*/
		/*List<User> list = userMapper.selectByExample(userExample);*/
		User user = userService.login(email,password);
		System.out.println(user.getAccessToken());
	}


}
