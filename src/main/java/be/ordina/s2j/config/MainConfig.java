package be.ordina.s2j.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Main configuration class for the application.
 * Loads externalized application.properties, and sets up the datasource.
 */
@Configuration
@ComponentScan(basePackages = "be.ordina.s2j")
@PropertySource("classpath:application.properties")
public class MainConfig {


}
