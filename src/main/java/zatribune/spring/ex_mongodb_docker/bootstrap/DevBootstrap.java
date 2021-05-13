package zatribune.spring.ex_mongodb_docker.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import zatribune.spring.ex_mongodb_docker.entities.Role;
import zatribune.spring.ex_mongodb_docker.entities.User;
import zatribune.spring.ex_mongodb_docker.repositories.ProductRepository;
import zatribune.spring.ex_mongodb_docker.repositories.RoleRepository;
import zatribune.spring.ex_mongodb_docker.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Component//comment that out if you don't need initial data
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DevBootstrap(UserRepository userRepository,RoleRepository roleRepository,ProductRepository productRepository)
    {
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (userRepository.findAll().iterator().hasNext()){
            userRepository.deleteAll();
        }
        if (roleRepository.findAll().iterator().hasNext()){
            roleRepository.deleteAll();
        }
        initData();
    }

    public void initData(){
        List<String> descriptions= Arrays.asList("Ak-74","M-16","AR-15","Browning Auto 5","Ruger 10/22","Shotgun EG-22");
        List<Double> prices= Arrays.asList(100.0,255.0,300.0,140.0,500.0,175.50);
        Product product;
        for(int x=0;x<descriptions.size();x++){
            product=new Product();
            //product.setId(new ObjectId());
            product.setDescription(descriptions.get(x));
            product.setPrice(BigDecimal.valueOf(prices.get(x)));
            productRepository.save(product);
        }
        log.info("bootstrap data");
        Role role1 =new Role();
        role1.setName("ADMIN");

        Role role2 =new Role();
        role2.setName("USER");

        String pass="$2y$12$bwUGNLEwKKGA/CleGetPIOfJGGZsB9Ymj0KOmJirJ/pn/wdSQVfie";

        roleRepository.saveAll(Arrays.asList(role1, role2));
        User user1 =new User();
        user1.setUsername("user1@gmail.com");
        //strength 12 and input= 'pass'
        user1.setPassword(pass);
        user1.setPasswordConfirm(pass);
        user1.setRoles(new HashSet<>(Collections.singletonList(role1)));
        user1.setAccountNonExpired(Boolean.TRUE);
        user1.setAccountNonLocked(Boolean.TRUE);
        user1.setCredentialsNotExpired(Boolean.TRUE);
        user1.setEnabled(Boolean.TRUE);


        User user2 =new User();
        user2.setUsername("user2@gmail.com");
        //strength 12 and input= 'pass'
        user2.setPassword(pass);
        user2.setPasswordConfirm(pass);
        user2.setRoles(new HashSet<>(Collections.singletonList(role2)));
        user2.setAccountNonExpired(Boolean.TRUE);
        user2.setAccountNonLocked(Boolean.TRUE);
        user2.setCredentialsNotExpired(Boolean.TRUE);
        user2.setEnabled(Boolean.TRUE);

        User user3 =new User();
        user3.setUsername("user3@gmail.com");
        //strength 12 and input= 'pass'
        user3.setPassword(pass);
        user3.setPasswordConfirm(pass);
        user3.setRoles(new HashSet<>(Collections.singletonList(role2)));
        user3.setAccountNonExpired(Boolean.TRUE);
        user3.setAccountNonLocked(Boolean.TRUE);
        user3.setCredentialsNotExpired(Boolean.TRUE);
        user3.setEnabled(Boolean.TRUE);
        userRepository.saveAll(List.of(user1, user2,user3));
    }

}
