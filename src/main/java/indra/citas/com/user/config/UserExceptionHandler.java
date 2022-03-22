package indra.citas.com.user.config;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity <Object> handleAllExceptions
	(Exception ex, WebRequest request){
		ExceptionResponse er=  new ExceptionResponse(new Date(),request.getDescription(false),ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity <Object> handleNotFoundExceptions
	(UserNotFoundException ex, WebRequest request){
		ExceptionResponse er=  new ExceptionResponse(new Date(),request.getDescription(false),ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse er=  new ExceptionResponse(new Date(),"Validation Failed",ex.getMessage());		
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}
	
}
