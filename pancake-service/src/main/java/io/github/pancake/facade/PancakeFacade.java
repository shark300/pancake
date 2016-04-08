package io.github.pancake.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pancake.factory.PancakeFactory;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.PancakeService;

/**
 * PancakeService consumer class.
 * 
 * @author Adorjan Nagy
 */
@Component
public class PancakeFacade {
    private PancakeService pancakeService;
    private PancakeFactory pancakeFactory;

    /**
     * @param pancakeService
     * @param pancakeFactory
     */
    @Autowired
    public PancakeFacade(PancakeService pancakeService, PancakeFactory pancakeFactory) {
        this.pancakeService = pancakeService;
        this.pancakeFactory = pancakeFactory;
    }

    public List<Pancake> getOrderablePancakes() {
        return pancakeFactory.getObject();
    }
}
