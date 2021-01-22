package zatribune.spring.ex_mongodb_docker.converters;

import zatribune.spring.ex_mongodb_docker.commands.ProductCommand;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {
    @Override
    public ProductCommand convert(Product product) {
        ProductCommand productCommand = new ProductCommand();
        productCommand.setId(product.getId().toHexString());
        productCommand.setDescription(product.getDescription());
        productCommand.setPrice(product.getPrice());
        productCommand.setImageUrl(product.getImageUrl());
        return productCommand;
    }
}
