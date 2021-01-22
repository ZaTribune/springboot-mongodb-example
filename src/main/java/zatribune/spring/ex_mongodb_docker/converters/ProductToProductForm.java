package zatribune.spring.ex_mongodb_docker.converters;

import zatribune.spring.ex_mongodb_docker.commands.ProductForm;
import zatribune.spring.ex_mongodb_docker.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId().toHexString());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
