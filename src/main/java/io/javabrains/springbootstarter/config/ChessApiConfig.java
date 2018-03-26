package io.javabrains.springbootstarter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This global configuration enables CORS requests from any origin to any endpoint in the application.
 * By default, this allows HEAD, GET, and POST, so added the allowedMethods to include PUT and DELETE.
 */


@Configuration
@EnableWebMvc
public class ChessApiConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}