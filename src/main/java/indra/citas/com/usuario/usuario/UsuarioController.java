package indra.citas.com.usuario.usuario;


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
public class UsuarioController {

	@Autowired
	private UsuarioDaoService service;
	
	@Operation(description = "es utilizado para obtener la informacion"
			+ " de un candidato"
			+ " mediante el uso de un GetMapping, requiriendo unicamente"
			+ " el id")
		@ApiResponse(responseCode = "200", 
		description = "Se a encontrado el usuario",
		content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))})
		@ApiResponse(responseCode = "404", 
		description = "no se encontro el usuario",
		content = {@Content(mediaType = "application/json")})
	@GetMapping("usuarios/{id}")
	public Usuario obtenerUsuario(@PathVariable Integer id) {
		return service.find(id);
	}

	@Operation(description = "es utilizado para obtener la informacion"
			+ " de todos los candidatos")
		@ApiResponse(responseCode = "200", 
		description = "Ok",
		content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))})
		@ApiResponse(responseCode = "404", 
		description = "no se encontro informacion",
		content = {@Content(mediaType = "application/json")})

	@GetMapping("usuarios/")
	public List<Usuario> obtenerUsuario() {
		return service.findAll();
	}

	
	@Operation(description = "es utilizado para generar un nuevo"
			+ "usuario")
		@ApiResponse(responseCode = "201", 
		description = "Se a creado el usuario",
		content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))})
		@ApiResponse(responseCode = "400", 
		description = "Error",
		content = {@Content(mediaType = "application/json")})
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> crearUsuario(@Valid @RequestBody Usuario usuario ) {
		Usuario usuarioGuardado=service.save(usuario);
		URI ubicacion =ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{"+usuarioGuardado.getId()+"}").
		buildAndExpand(usuarioGuardado.getId()).
		toUri();
		
		return ResponseEntity.created(ubicacion).build();
		
	}
	
	@Operation(description = "es utilizado para borrar a un candidato"
			+ "mediante el uso de un DeleteMapping")
	@DeleteMapping("/usuarios/{id}")
	public Usuario borrarUsuario(@PathVariable Integer id) {
		return service.deleteById(id);
	}
	
	@Operation(description = "nos permitira Modificar usuarios/candidato mediante el metodo put, "
			+ "se requiere el objeto mediante el un formato que sea aceptado, asi como"
			+ "es requerido el id del usuario/candidato")
	@PutMapping("/usuarios/{id}")
	public Usuario modificarUsuario(@Valid @RequestBody Usuario usuario,
			@PathVariable Integer id) {
		return service.update(id,usuario);
	}
	
}
