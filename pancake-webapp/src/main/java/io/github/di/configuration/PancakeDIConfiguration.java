package io.github.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.pancake.service.PancakeService;
/**
 * @author Adorjan Nagy
 *
 */
@Configuration
@ComponentScan(value={"io.github.di.consumer"})
public class PancakeDIConfiguration {
    @Bean
    public PancakeService retrievePancakes() {
        return new PancakeService();
    }
}
