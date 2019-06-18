package com.project.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.controller.UserHandler;

@SpringBootTest
public class SpringBootDemoTest {
	private MockMvc mock;
	@Before
	public void before(){
		mock = MockMvcBuilders.standaloneSetup(new UserHandler()).build();
	}
	
	@Test
	public void test(){
		try {
			mock.perform(MockMvcRequestBuilders
					.post("/login?name=xiaowang")
					.content("address=wuhouq")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
