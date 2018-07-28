package com.ScuSoftware.Factorio;

import com.ScuSoftware.Factorio.dao.MemberMapper;
import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactorioApplicationTests {

	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private MemberMapper memberMapper;
	@Test
	public void contextLoads() {
		User user;
		user = userServiceImpl.getUserByUsername("Arch Yi");
		Member member = memberMapper.selectByPrimaryKey(user.getMemberId());

		System.out.printf("name:%s\n" +
				"id:%s\n",user.getUserName(),member.getStudentId());

	}

}
