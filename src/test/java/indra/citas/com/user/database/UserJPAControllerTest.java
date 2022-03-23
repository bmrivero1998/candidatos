package indra.citas.com.user.database;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import indra.citas.com.user.user.User;

public class UserJPAControllerTest {

	@InjectMocks
	UserJPAController userJPAController;
	private User user;

	@Autowired
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(userJPAController).build();	
		user= new User(0, "a", "b", "c", 1, "d", "e", "f@g.com");
		userJPAController.createUser(user);
	}

	
	@Test
	public void testRetrieveAllUsers() throws Exception {
		List<User> result;
		// default test
		result = userJPAController.retrieveAllUsers();
		assertNotNull(result);
	}

	@Test
	public void testRetrieveUser() throws Exception {
		int id = 0;
		EntityModel<User> result;
		// default test
		result = userJPAController.retrieveUser(id);
		assertNotNull(result);
	}

	@Test
	public void testCreateUser() throws Exception {
		ResponseEntity<Object> result;
		// default test
		result = userJPAController.createUser(user);
		assertNotNull(result);
	}

	@Test
	public void testDeleteUser() throws Exception {
		int id = 0;
		// default test
		userJPAController.deleteUser(id);
		Assert.assertTrue(true);
	}
}