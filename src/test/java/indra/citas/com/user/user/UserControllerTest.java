package indra.citas.com.user.user;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class UserControllerTest {

	@Mock
	private UserDaoService userDaoService;
	@InjectMocks
	private UserController userController;
	
	@Autowired
	MockMvc mockMvc;
	
	private User user;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();	
		user= new User(1, "a", "b", "c", 1, "d", "e", "f@g.com");
	}
	
	
	@Test
	void findAll() {
		when(userDaoService.findAll()).thenReturn(Arrays.asList(user));
		assertNotNull(userDaoService.findAll());
	}
	

	@Test
	public void testGetUser() throws Exception {
		Integer id = 0;
		User result;
		result = userController.getUser(id);
		assertNotNull(result);
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> result;
		result = userController.getUsers();
		assertNotNull(result);
	}

	@Test
	public void testCreateUser() throws Exception {
		ResponseEntity<Object> result;
		result = userController.createUser(user);
		assertNotNull(result);
	}

	@Test
	public void testDeleteUser() throws Exception {
		User result;
		result = userController.deleteUser(user.getId());
		assertNotNull(result);
	}

	@Test
	public void testUpdateUser() throws Exception {
		User result;
		result = userController.updateUser(user);
		assertNotNull(result);
	}
}