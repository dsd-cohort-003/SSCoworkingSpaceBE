package com.teamsamuelsagar.coworkingspace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    /**
     * Configure global CORS settings for all endpoints.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                  // apply CORS for every path in your app
                  .addMapping("/**")
                  // allow calls from React dev server
                  .allowedOrigins("http://localhost:5173")
                  // allow all HTTP methods (GET, POST, etc.)
                  .allowedMethods("*")
                  // allow credentials (cookies, auth headers) if you need them
                  .allowCredentials(true);
            }
        };
    }
}