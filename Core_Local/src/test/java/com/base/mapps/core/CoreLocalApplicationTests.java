package com.base.mapps.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mapps.CoreLocalApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreLocalApplication.class)
@WebAppConfiguration
public class CoreLocalApplicationTests {

	@Test
	public void contextLoads() {
	}

}
