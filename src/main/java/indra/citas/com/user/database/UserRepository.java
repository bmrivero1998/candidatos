package indra.citas.com.user.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import indra.citas.com.user.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
