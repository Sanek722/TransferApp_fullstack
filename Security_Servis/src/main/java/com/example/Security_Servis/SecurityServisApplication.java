package com.example.Security_Servis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.Security_Servis")
public class SecurityServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServisApplication.class, args);
	}

}
