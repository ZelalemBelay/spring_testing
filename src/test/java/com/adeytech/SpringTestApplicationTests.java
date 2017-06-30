package com.adeytech;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
public class SpringTestApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
 	MyService myService;

	@Before
			public void setup()
	{
		this.myService = new MyService();
	}

	@Test
	public void contextLoads() throws Exception {

		int custID = 8;
		String x = myService.getCustomer(8);
		System.out.println(x);

		given(myService.getCustomer(custID)).willReturn("My Customer");

		mockMvc.perform(get(MyController.URL, custID).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(content().string("My Customer"));

	}

	@Test
	public void testWhen() throws Exception {
		when(myService.getCustomer(8)).thenReturn("My Customer");

		mockMvc.perform(get(MyController.URL, 8).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().string("My Customer"));

		verify(myService).getCustomer(8);
	}

}
