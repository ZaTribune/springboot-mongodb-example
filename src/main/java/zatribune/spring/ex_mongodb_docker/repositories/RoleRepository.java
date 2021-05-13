package zatribune.spring.ex_mongodb_docker.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.ex_mongodb_docker.entities.Role;


public interface RoleRepository extends CrudRepository<Role,String> {
}
