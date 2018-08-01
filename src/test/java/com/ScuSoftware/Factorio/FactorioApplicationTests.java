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

	@Test
	public void contextLoads() {
		List<Comments> list = commentsMapper.selectByExampleWithBLOBs(commentsExample);
		for(Comments comments:list){
			System.out.println("id:"+comments.getId()+"content:"+comments.getContent());
		}

	}


}
