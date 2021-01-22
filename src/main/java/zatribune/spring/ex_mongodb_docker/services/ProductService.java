package zatribune.spring.ex_mongodb_docker.services;

import zatribune.spring.ex_mongodb_docker.commands.ProductCommand;
import zatribune.spring.ex_mongodb_docker.entities.Product;

import java.util.List;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductCommand productCommand);
}
