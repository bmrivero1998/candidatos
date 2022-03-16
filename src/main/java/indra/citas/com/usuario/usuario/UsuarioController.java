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


@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDaoService service;
	
	
	@GetMapping("usuarios/{id}")
	public Usuario obtenerUsuario(@PathVariable Integer id) {
		return service.find(id);
	}
	
	@GetMapping("usuarios/")
	public List<Usuario> obtenerUsuario() {
		return service.findAll();
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> crearUsuario(@Valid @RequestBody Usuario usuario ) {
		Usuario usuarioGuardado=service.save(usuario);
		URI ubicacion =ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{"+usuarioGuardado.getId()+"}").
		buildAndExpand(usuarioGuardado.getId()).
		toUri();
		
		return ResponseEntity.created(ubicacion).build();
		
	}
	
	@DeleteMapping("/usuarios/{id}")
	public Usuario borrarUsuario(@PathVariable Integer id) {
		return service.deleteById(id);
	}
	

	@PutMapping("/usuarios/{id}")
	public Usuario modificarUsuario(@Valid @RequestBody Usuario usuario,
			@PathVariable Integer id) {
		return service.update(usuario);
	}
	
}
