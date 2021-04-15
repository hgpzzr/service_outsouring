package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.mapper.PostMapper;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceImplTest {

	@Autowired
	PostMapper postMapper;

	@Test
	void insertPost() {
		GenerateIdUtil generateIdUtil = new GenerateIdUtil();
		String postId = generateIdUtil.getRandomId(postMapper,"PF");
		System.out.println("---------------------------------------------------------");
		System.out.println(postId);
	}
}