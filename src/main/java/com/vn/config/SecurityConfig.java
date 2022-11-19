package com.vn.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.vn.service.impl.CustomUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomUserDetailServiceImpl customUserDetailServiceImpl;

	// authentication

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { // TODO Auto-generated method stub
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(customUserDetailServiceImpl);
		
		auth.authenticationProvider(provider);
	}


	// authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		
			
			http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/j_spring_security_check")
            .usernameParameter("userName")
            .passwordParameter("password")
            .defaultSuccessUrl("/home")
            .failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					String userName = request.getParameter("userName");
                    String error = exception.getMessage();
                    System.out.println("A failed login attempt with userName: "
                                        + userName + ". Reason: " + error);
 
                    String redirectUrl = request.getContextPath() + "/login?error";
                    response.sendRedirect(redirectUrl);
					
				}
            })
            .and()
            .rememberMe()
            .rememberMeParameter("remember")
            .tokenValiditySeconds(2 * 24 * 60 * 60)
            .key("asdasdsadsadasdsad")
            .rememberMeCookieName("cookieRemember")
            .and()
            .logout()
            .logoutUrl("/logout")
            .deleteCookies("cookieRemember", "JSESSIONID")
            .clearAuthentication(true)
            .and()
			.authorizeHttpRequests()
			.antMatchers("/register", "/login","/login?error","*.css","*.webp", "*.js","/","*.img","/css/**","/img/**","/js/**", "/asserts/**" ,"/fontawesome-free-6.1.2-web/**").permitAll()
			.antMatchers("/home","/injection-result/list","/news/list").hasAnyAuthority("ADMIN","USER")
            .antMatchers("/employee/**","/customer/**","/injection-schedule/**","/injection-result/**","/vaccine/**","/vaccineType/**","/news/**","/report/**").hasAnyAuthority("ADMIN")
            
            .anyRequest().authenticated();
		
	}
	

	
}
