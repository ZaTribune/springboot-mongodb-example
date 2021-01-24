package zatribune.spring.ex_mongodb_docker.bootstrap;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import zatribune.spring.ex_mongodb_docker.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component//comment that out if you don't need initial data
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository repository;

    @Autowired
    public DevBootstrap(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<String> descriptions= Arrays.asList("Ak-74","M-16","AR-15","Browning Auto 5","Ruger 10/22");
        List<Integer> prices= Arrays.asList(100,255,300,140,500);
        Product product;
        for(int x=0;x<descriptions.size();x++){
            product=new Product();
            //product.setId(new ObjectId());
            product.setDescription(descriptions.get(x));
            product.setPrice(BigDecimal.valueOf(prices.get(x)));
            repository.save(product);
        }
    }
}
