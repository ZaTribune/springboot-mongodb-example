package zatribune.spring.ex_mongodb_docker.repositories;

import zatribune.spring.ex_mongodb_docker.entities.Product;
import org.springframework.data.repository.CrudRepository;
import zatribune.spring.ex_mongodb_docker.entities.User;

/**
 * Created by ZaTribune on 22/jan/2021.
 */
public interface ProductRepository extends CrudRepository<Product, String> {
    Iterable<Product>findAllByUserEquals(User user);
}
