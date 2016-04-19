package io.github.pancake.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.pancake.OrderControllerServlet;

/**
 * Spring configuration class.
 * 
 * @author Adorjan Nagy
 */
@Configuration
@ComponentScan(basePackageClasses = OrderControllerServlet.class)
public class PancakeConfiguration {

}
