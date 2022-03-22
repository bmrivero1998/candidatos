package indra.citas.com.user.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
public class UserDaoServiceTest {

	
	@InjectMocks
	private UserDaoService userDaoService;
	
	@Autowired
	MockMvc mockMvc;
	
	private User user;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userDaoService).build();	
		user= new User(1, "a", "b", "c", 1, "d", "e", "f@g.com");
	}
	

	@Test
	public void testFindAll() throws Exception {
		List<User> result;
		// default test
		result = userDaoService.findAll();
		assertNotNull(result);
	}

	@Test
	public void testUpdate() throws Exception {
	
		User result;

		// default test
		result = userDaoService.update(user);
		assertNotNull(result);
	}

	@Test
	public void testSave() throws Exception {
		User result;

		// default test

		result = userDaoService.save(user);
		assertNotNull(result);
	}

	@Test
	public void testFind() throws Exception {
		User result;

		// default test
		result = userDaoService.find(user.getId());
		assertNotNull(result);
	}

	@Test
	public void testDeleteById() throws Exception {
		User result;
		// default test
		result = userDaoService.deleteById(user.getId());
		assertNotNull(result);
	}
}