package springMvc;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.dta.App;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = App.class)
@Transactional
public abstract class IntegrationTest {
	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
	protected JsonHelper jsonHelper;
	protected MockMvc mockMvc;
	
	@Before
	public void initMockMcv() {
	mockMvc = MockMvcBuilders
	.webAppContextSetup(wac)
	.build();
	}
}