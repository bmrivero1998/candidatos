package indra.citas.com.usuario.usuario;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class UsuarioControllerTest {

	private UsuarioController createTestSubject() {
		return new UsuarioController();
	}

	@Test
	public void testObtenerUsuario() throws Exception {
		UsuarioController testSubject;
		Integer id = 0;
		Usuario result;
		// default test
		testSubject = createTestSubject();
		result = testSubject.obtenerUsuario(id);
		assertEquals(result,testSubject.obtenerUsuario(id));
	}

	@Test
	public void testObtenerUsuario_1() throws Exception {
		UsuarioController testSubject;
		List<Usuario> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.obtenerUsuario();
		assertEquals(result,testSubject.obtenerUsuario());
	}

	@Test
	public void testCrearUsuario() throws Exception {
		UsuarioController testSubject;
		Usuario usuario = null;
		ResponseEntity<Object> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.crearUsuario(usuario);
		assertEquals(result,testSubject.crearUsuario(usuario));
	}

	@Test
	public void testBorrarUsuario() throws Exception {
		UsuarioController testSubject;
		Integer id = 0;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.borrarUsuario(id);
		assertEquals(result,testSubject.borrarUsuario(id));
	}

	@Test
	public void testModificarUsuario() throws Exception {
		UsuarioController testSubject;
		Usuario usuario = null;
		Integer id = 0;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.modificarUsuario(usuario, id);
		assertEquals(result,testSubject.modificarUsuario(usuario, id));
	}
}