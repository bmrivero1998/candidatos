package indra.citas.com.usuario.usuario;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class UsuarioDaoServiceTest {

	private UsuarioDaoService createTestSubject() {
		return new UsuarioDaoService();
	}

	@Test
	public void testFindAll() throws Exception {
		UsuarioDaoService testSubject;
		List<Usuario> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAll();
		assertEquals(result,testSubject.findAll());
	}

	@Test
	public void testUpdate() throws Exception {
		UsuarioDaoService testSubject;
		Usuario usuario = null;
		Usuario nuevoUsuario = null;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.update(usuario);
		assertEquals(result,testSubject.update(usuario));
	}

	@Test
	public void testSave() throws Exception {
		UsuarioDaoService testSubject;
		Usuario usuario = null;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.save(usuario);
		assertEquals(result,testSubject.save(usuario));
	}

	@Test
	public void testFind() throws Exception {
		UsuarioDaoService testSubject;
		int id = 0;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.find(id);
		assertEquals(result,testSubject.find(id));
	}

	@Test
	public void testDeleteById() throws Exception {
		UsuarioDaoService testSubject;
		int id = 0;
		Usuario result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.deleteById(id);
		assertEquals(result,testSubject.deleteById(id));
	}
}