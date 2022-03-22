package indra.citas.com.user.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import indra.citas.com.user.config.UserNotFoundException;

@Component
public class UserDaoService {
	private static List <User> users = new ArrayList<>();
	private int idgenerado=0;
	
	public List<User> findAll(){
		return users;
	}
	
	public User update(User user){
		User tmp = user;
		users.set(user.getId(), tmp);
		tmp = users.get(user.getId());
		return tmp;
		
	}
	
	public User save(User user) {
		if(users.contains(user)) {
			throw new UserNotFoundException("the user is duplicated in the system");
		}
		if(user.getId()==null) {
			idgenerado+=1;
			user.setId(idgenerado);
		}
		users.add(user);
		return user;
	}
	
	public User find(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator <User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
