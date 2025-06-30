package com.example.Security_Servis.Controllers;

import com.example.Security_Servis.Configuration.JwtTokenProvider;
import com.example.Security_Servis.Model.LoginRequest;
import com.example.Security_Servis.Model.Userdata;
import com.example.Security_Servis.Service.JwtResponse;
import com.example.Security_Servis.Service.UserdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserdataService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Userdata user) {
        // Хэширование пароля перед сохранением
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole().equals("Admin"))
        {
            user.setRole("Admin");
        }
        else
        {
            user.setRole("User");
        }
        userService.saveUser(user);
        return "User registered successfully!";
    }
    @GetMapping("/take")
    public String getUsers(@RequestParam String username, @RequestParam String password)
    {
        Userdata bob = userService.getUser(username);
        return "Returns: "+ bob.getId() + " " + bob.getUsername() +" " + bob.getPassword() +" " + bob.getRole();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Аутентификация пользователя
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
            if (!authentication.isAuthenticated())
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed! ");
            }
            String token = jwtTokenProvider.generateToken(loginRequest);
            // Возвращаем успешное сообщение
            return ResponseEntity.ok(new JwtResponse(token));


        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }

    }
}