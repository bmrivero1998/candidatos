package indra.citas.com.user.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class User {

	private Integer id;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private Integer celular;
	private String perfilTI;
	private String perfilTICalculado;
	private String correo;
	
}
