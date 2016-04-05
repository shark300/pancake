package io.github.pancake.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.PancakeService;

/**
 * PancakeService consumer class.
 * 
 * @author Adorjan Nagy
 */
@Component
public class PancakeApplication {
    private PancakeService service;

    public List<Pancake> getOrderablePancakes() {
        return service.getOrderablePancakes();
    }

    @Autowired
    public void setService(PancakeService service) {
        this.service = service;
    }
}
