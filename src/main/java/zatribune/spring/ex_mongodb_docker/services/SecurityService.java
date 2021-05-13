package zatribune.spring.ex_mongodb_docker.services;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
