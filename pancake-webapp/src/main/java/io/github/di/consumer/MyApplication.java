package io.github.di.consumer;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import io.github.pancake.service.PancakeService;

/**
 * @author Adorjan Nagy
 *
 */
@Component
public class MyApplication {
    private PancakeService service;

    public Set<String> retrievePancakes() {
        return this.service.retrievePancakes();
    }

    @Autowired
    public void setService(PancakeService service) {
        this.service = service;
    }
}
