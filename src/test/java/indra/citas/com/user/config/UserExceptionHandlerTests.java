package indra.citas.com.user.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

@SpringBootTest
public class UserExceptionHandlerTests {

	@Mock
	private UserNotFoundException userNotFoundException;
	
	@InjectMocks
	private UserExceptionHandler userExceptionHandler;


	@Test
	public void testHandleAllExceptions() throws Exception {
		Exception ex = null;
		WebRequest request = null;
		ResponseEntity<Object> result;
		// default test
		result = userExceptionHandler.handleAllExceptions(ex, request);
		assertNotNull(result);
	}

	@Test
	public void testHandleNotFoundExceptions() throws Exception {
		UserNotFoundException ex = null;
		WebRequest request = null;
		ResponseEntity<Object> result;
		// default test
		result = userExceptionHandler.handleNotFoundExceptions(ex, request);
		assertNotNull(result);
	}

	@Test
	public void testHandleMethodArgumentNotValid() throws Exception {
		ResponseEntity<Object> result;
		// default test
		result = Whitebox.invokeMethod(userExceptionHandler, "handleMethodArgumentNotValid", new Object[] {
			MethodArgumentNotValidException.class, HttpHeaders.class, HttpStatus.class, WebRequest.class });
		assertNotNull(result);
	}
}