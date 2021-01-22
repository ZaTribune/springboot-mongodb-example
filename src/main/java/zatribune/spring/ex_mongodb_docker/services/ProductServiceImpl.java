package zatribune.spring.ex_mongodb_docker.services;

import zatribune.spring.ex_mongodb_docker.commands.ProductCommand;
import zatribune.spring.ex_mongodb_docker.converters.ProductCommandToProduct;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import zatribune.spring.ex_mongodb_docker.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCommandToProduct productCommandToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductCommandToProduct productCommandToProduct) {
        this.productRepository = productRepository;
        this.productCommandToProduct = productCommandToProduct;
    }


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductCommand productCommand) {
        Product savedProduct = saveOrUpdate(productCommandToProduct.convert(productCommand));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
