package com.assignment.studentdetails.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ConfigurationProperties(value = "application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class StudentdetailsApplicationTests {

	@Test
	void contextLoads() {
	}

}
