package indra.citas.com.user.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="the firstname has less than two characters")
	private String name;
	@Size(min=2,message="the second name has less than two characters")
	private String lastName;
	@Size(min=2,message="the optional second name has less than two characters")
	private String optionalLastName;
	private Integer cellNumber;
	private String tIProfile;
	private String calculatedTIProfile;
	@Email
	private String email;
	
}
