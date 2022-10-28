package com.vn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css/**", "/js/**","/fontawesome-free-6.1.1-web/**")
                .addResourceLocations("/asserts/css/", "/asserts/js/", "/asserts/fontawesome-free-6.1.1-web/");

    }
}
