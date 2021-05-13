package zatribune.spring.ex_mongodb_docker.services;

import org.springframework.security.core.userdetails.UserDetails;
import zatribune.spring.ex_mongodb_docker.entities.User;

public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {
    UserDetails loadUserByUsername(String username);
    void save(User user);
    void saveToDefaults(User user);
}
