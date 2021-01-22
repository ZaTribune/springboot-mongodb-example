package zatribune.spring.ex_mongodb_docker.converters;

import zatribune.spring.ex_mongodb_docker.commands.ProductCommand;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Component
public class ProductCommandToProduct implements Converter<ProductCommand, Product> {

    @Override
    public Product convert(ProductCommand productCommand) {
        Product product = new Product();
        if (productCommand.getId() != null  && !productCommand.getId().isEmpty()) {
            product.setId(new ObjectId(productCommand.getId()));
        }
        product.setDescription(productCommand.getDescription());
        product.setPrice(productCommand.getPrice());
        product.setImageUrl(productCommand.getImageUrl());
        return product;
    }
}
