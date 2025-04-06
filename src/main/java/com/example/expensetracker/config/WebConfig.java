package com.example.expensetracker.config; // Or your preferred config package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply CORS rules to your API paths
            .allowedOrigins("http://localhost:8084") // !!! IMPORTANT: Allow your frontend origin
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow necessary HTTP methods
            .allowedHeaders("*") // Allow all headers (including Authorization)
            .allowCredentials(true); // Allow sending credentials (like Basic Auth header)
      }
    };
  }
}
