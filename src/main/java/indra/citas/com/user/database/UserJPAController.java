package indra.citas.com.user.database;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import indra.citas.com.user.config.UserNotFoundException;
import indra.citas.com.user.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class UserJPAController {

	
@Autowired
	private UserRepository userRepository;
	
@Operation(description = "is used to get the information" + "of all candidates")
@ApiResponse(responseCode = "200", description = "Okay", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
@ApiResponse(responseCode = "404", description = "no information found", content = {
		@Content(mediaType = "application/json") })

	//Obtener Users
	@GetMapping("/jpa/users/")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	
	
	@Operation(description = "is used to get the information" + "of a candidate"
			+ " by using a GetMapping, requiring only" + " the id")
	@ApiResponse(responseCode = "200", description = "User found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@ApiResponse(responseCode = "404", description = "user not found", content = {
			@Content(mediaType = "application/json") })
	//obtener un solo user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
			EntityModel<User> model = EntityModel.of(user.get());
			
			WebMvcLinkBuilder linkToUsers = 
					linkTo(methodOn(this.getClass()).retrieveAllUsers());
			model.add(linkToUsers.withRel("all-users"));
			
			return model;
	}
	
	@Operation(description = "is used to generate a new" + "user")
	@ApiResponse(responseCode = "201", description = "The user has been created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@ApiResponse(responseCode = "400", description = "Error", content = { @Content(mediaType = "application/json") })

	//crear un user
	@PostMapping("/jpa/users/")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user ) {
		User userGuardado=userRepository.save(user);
		URI ubicacion =ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}").
		buildAndExpand(userGuardado.getId()).
		toUri();
		
		return ResponseEntity.created(ubicacion).build();
		
	}
	
	
	
	//borrar un user
	@Operation(description = "is used to delete a candidate" + "by using a DeleteMapping")
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);	
	}
	
	
}
