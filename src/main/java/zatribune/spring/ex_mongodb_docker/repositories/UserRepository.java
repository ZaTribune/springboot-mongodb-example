package zatribune.spring.ex_mongodb_docker.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.ex_mongodb_docker.entities.User;

public interface UserRepository extends CrudRepository<User,String> {
    User findDistinctByUsername(String username);
}
