package com.vn;

import com.vn.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class FptMockProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FptMockProjectApplication.class, args);
	}
}
