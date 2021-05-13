package zatribune.spring.ex_mongodb_docker.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zatribune.spring.ex_mongodb_docker.entities.User;
import zatribune.spring.ex_mongodb_docker.services.SecurityService;
import zatribune.spring.ex_mongodb_docker.services.UserDetailsService;

import javax.validation.Valid;

@Slf4j
@Controller
public class MainController {
    private final UserDetailsService userDetailsService;
    private final SecurityService securityService;

    @Autowired
    public MainController(UserDetailsService userDetailsService, SecurityService securityService) {
        this.userDetailsService = userDetailsService;
        this.securityService = securityService;
    }

    @GetMapping({"/", "/home","index"})
    public String welcome(Model model) {

        return "/product/list";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/index";
        }
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm")@Valid User userForm, BindingResult bindingResult) {

        //customized check
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            log.error("Passwords don't match.");
            bindingResult.rejectValue("passwordConfirm","","Password Fields Must match.");
        }
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userDetailsService.save(userForm);
        //todo: add account confirmation
        //todo:add user home page
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            log.info("login status:User Already logged in.");
            // if already authenticated ->back to main page
            return "redirect:/product/list";
        }

        if (error != null)//there's an error passed
            model.addAttribute("error", "Your username/password is invalid.");

        if (logout != null)//there's a message passed
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }




}
