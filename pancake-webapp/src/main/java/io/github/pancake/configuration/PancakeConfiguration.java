package io.github.pancake.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.pancake.service.PancakeService;
/**
 * Spring configuration class.
 * 
 * @author Adorjan Nagy
 */
@Configuration
@ComponentScan(value={"io.github.pancake.consumer"})
public class PancakeConfiguration {
    @Bean
    public PancakeService retrievePancakes() {
        return new PancakeService();
    }
}
