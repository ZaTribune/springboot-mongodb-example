package zatribune.spring.ex_mongodb_docker.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import zatribune.spring.ex_mongodb_docker.repositories.RoleRepository;
import zatribune.spring.ex_mongodb_docker.repositories.UserRepository;
import zatribune.spring.ex_mongodb_docker.services.UserDetailsServiceImpl;


@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfig(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // Create source of Authentication manager
    //then it will call the two methods to create the user service & the encoder

    @Bean
    public PasswordEncoder passwordEncoder() {
        log.warn("passwordEncoder()");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        this.passwordEncoder = passwordEncoder;
        return passwordEncoder;
    }

    // Specify the manager
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        log.warn("authenticationManagerBean()");
        //will call the builder if not initialized
        //so we'll specify a builder of our own
        return authenticationManager();
    }

    //the manager builder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.warn("configure(AuthenticationManagerBuilder auth)");
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //because it depends on injected beans
        log.warn("userDetailsService()");
        return new UserDetailsServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.warn("configure(HttpSecurity http)");

        http.anonymous()//allow the condition of anonymous users
                //while this one will permit access for all roles weather anonymous or else
                .and().authorizeRequests().antMatchers("/","/css/**", "/js/**","/webjars/**","/images/**","/registration").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
//        http.anonymous()
//            .and().formLogin().failureHandler((request, response, exception) -> {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write(exception.getMessage());
//        }).and().logout().logoutUrl("/logout").logoutSuccessHandler((request, response, authentication) -> {
//            log.info("Logout Successful.");
//            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//            response.setHeader("Location", URI.create("/?logout=true").toString());
//        });
    }
}
