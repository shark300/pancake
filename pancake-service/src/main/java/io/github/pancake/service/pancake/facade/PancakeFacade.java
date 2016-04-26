package io.github.pancake.service.pancake.facade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

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

    @Autowired
    public PancakeFacade(PancakeFactory pancakeFactory) {
        this.pancakeFactory = pancakeFactory;
    }

    /**
     * Facade method to get {@link List} of available pancakes
     * @return {@link List} of available pancakes
     */
    public List<Pancake> getOrderablePancakes() {
        return pancakeFactory.getObject();
    }

    /**
     * Facade method to get {@link List} of available amounts
     * @return {@link List} of available amounts
     */
    public List<Integer> getAvailableAmounts() {
        return IntStream.rangeClosed(0, orderLimit).boxed().collect(Collectors.toList());
    }

    /**
     * Facade method to get the order limit
     * @return the order limit
     */
    public int getOrderLimit() {
        return orderLimit;
    }

    @VisibleForTesting
    void setOrderLimit(int orderLimit) {
        this.orderLimit = orderLimit;
    }
}