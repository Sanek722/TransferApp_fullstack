package org.example.Controlers;


import org.example.Security.AuthTokenFilter;
import org.example.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class RegistrationControler
{
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    AuthTokenFilter authTokenFilter;
    @GetMapping("/login")
    public String logining() {
        return "login";
    }
    @GetMapping("/logout")
    public String logouting() {
        return "logout";
    }
    @GetMapping("/logouting")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
//    @PostMapping("/registration")
//    public String addUser(UserData user, Map<String, Object> model)
//    {
//        UserData userData = new UserData();
//        userData.setPassword(securityConfig.bCryptPasswordEncoder().encode(user.getPassword()));
//        userData.setId(user.getId());
//        userData.setUsername(user.getUsername());
//        userRepository.save(userData);
//        return "redirect:/login";
//    }
}
