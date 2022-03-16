package indra.citas.com.usuario.usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDaoService {
	private static List <Usuario> usuarios = new ArrayList<>();
	private int idgenerado=0;
	
	public List<Usuario> findAll(){
		return usuarios;
	}
	
	public Usuario update(Usuario usuario){
		return usuarios.set(usuario.getId(), usuario);
	}
	
	public Usuario save(Usuario usuario) {
		if(usuario.getId()==null) {
			idgenerado+=1;
			usuario.setId(idgenerado);
		}
		usuarios.add(usuario);
		return usuario;
	}
	
	public Usuario find(int id) {
		for(Usuario usuario:usuarios) {
			if(usuario.getId()==id) {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario deleteById(int id) {
		Iterator <Usuario> iterator = usuarios.iterator();
		while(iterator.hasNext()) {
			Usuario usuario = iterator.next();
			if(usuario.getId()==id) {
				iterator.remove();
				return usuario;
			}
		}
		return null;
	}
}
