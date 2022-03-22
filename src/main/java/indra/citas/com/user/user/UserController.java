package indra.citas.com.user.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@Operation(description = "is used to get the information" + "of a candidate"
			+ " by using a GetMapping, requiring only" + " the id")
	@ApiResponse(responseCode = "200", description = "User found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@ApiResponse(responseCode = "404", description = "user not found", content = {
			@Content(mediaType = "application/json") })
	@GetMapping("users/{id}")
	public User getUser(@PathVariable Integer id) {
		 return service.find(id);

	}

	@Operation(description = "is used to get the information" + "of all candidates")
	@ApiResponse(responseCode = "200", description = "Okay", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@ApiResponse(responseCode = "404", description = "no information found", content = {
			@Content(mediaType = "application/json") })

	@GetMapping("users/")
	public List<User> getUsers() {
		return service.findAll();
	}

	@Operation(description = "is used to generate a new" + "user")
	@ApiResponse(responseCode = "201", description = "The user has been created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@ApiResponse(responseCode = "400", description = "Error", content = { @Content(mediaType = "application/json") })

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User userSaved = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{" + userSaved.getId() + "}")
				.buildAndExpand(userSaved.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@Operation(description = "is used to delete a candidate" + "by using a DeleteMapping")
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable Integer id) {
		return service.deleteById(id);
	}

	@Operation(description = "will allow us to Modify users/candidate through the put method, "
			+ "the object is required by a format that is accepted, as well as" + "user/candidate id is required")
	@PutMapping("/users/")
	public User updateUser(@Valid @RequestBody User user) {
		return service.update(user);
	}

}
