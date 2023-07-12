package saatairlinesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saatairlinesapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailAndPassword(String email, String password);
}

