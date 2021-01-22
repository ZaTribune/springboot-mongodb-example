package zatribune.spring.ex_mongodb_docker.repositories;

import zatribune.spring.ex_mongodb_docker.domain.Product;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
public interface ProductRepository extends CrudRepository<Product, String> {
}
