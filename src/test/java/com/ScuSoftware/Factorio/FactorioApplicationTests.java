package com.ScuSoftware.Factorio;

import com.ScuSoftware.Factorio.dao.UserMapper;

import com.ScuSoftware.Factorio.service.Impl.UserServiceImpl;
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
	@Test
	public void contextLoads() {
		userServiceImpl.print(1);
	}

}
