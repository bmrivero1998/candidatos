package indra.citas.com.user;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import indra.citas.com.user.config.UserExceptionHandlerTests;
import indra.citas.com.user.user.UserControllerTest;
import indra.citas.com.user.user.UserDaoServiceTest;

@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
		UserExceptionHandlerTests ueht;
		UserControllerTest uct;
		UserDaoServiceTest udst;
		assertTrue(true);
		}

}
