package springMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.hamcrest.Matchers.*;

import fr.dta.modele.User;
import fr.dta.service.UserService;

public class UserIntegrationTest extends IntegrationTest {

	@Autowired
	UserService userService;

	@Test
	public void testCreate() throws Exception {
		User u = new User("test");
		u.setLogin("test");
		this.mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
				.content(jsonHelper.serialize(u))).andExpect(status().isCreated());
		 this.mockMvc.perform(get("/api/users")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(3))).andExpect(status().isOk()); 
	}

	@Test
	public void testUpdate() throws Exception {
		User user = userService.findById(1l);
		Assert.assertEquals("admin@iocean.fr", user.getLogin());

		user.setLogin("test@iocean.fr");
		this.mockMvc
				.perform(put("/api/users/{id}", 1).contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
						.content(jsonHelper.serialize(user)))
				.andExpect(jsonPath("$.login").value("test@iocean.fr")).andExpect(status().isOk());
	}

	@Test
	public void testGetUser() throws Exception {
		this.mockMvc.perform(get("/api/users/{id}", 1)).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.login").value("admin@iocean.fr"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetNotFoundUser() throws Exception {
		this.mockMvc.perform(get("/api/users/{id}", 55)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		this.mockMvc.perform(get("/api/users")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(status().isOk()); 
	}

	
}
