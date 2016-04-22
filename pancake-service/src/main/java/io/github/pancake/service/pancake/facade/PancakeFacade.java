package io.github.pancake.service.pancake.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.pancake.factory.PancakeFactory;

/**
 * PancakeFactory bean provider class.
 *
 * @author Adorjan Nagy
 * @author Bence_Kornis
 */
@Component
public class PancakeFacade {
    private final PancakeFactory pancakeFactory;
    @Value("${order.limit}")
    private int orderLimit;

    /**
     * @param pancakeFactory provides list of available pancake types
     */
    @Autowired
    public PancakeFacade(PancakeFactory pancakeFactory) {
        this.pancakeFactory = pancakeFactory;
    }

    public List<Pancake> getOrderablePancakes() {
        return pancakeFactory.getObject();
    }

    public List<Integer> getAvailableAmounts() {
        List<Integer> availableAmounts = new ArrayList<>();
        for (int i = 0; i <= orderLimit; i++) {
            availableAmounts.add(i);
        }
        return availableAmounts;
    }

    public int getOrderLimit() {
        return orderLimit;
    }
}