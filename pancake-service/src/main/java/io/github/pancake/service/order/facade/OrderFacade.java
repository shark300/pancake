package io.github.pancake.service.order.facade;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import io.github.pancake.service.order.domain.Order;

/**
 * Facade containing methods related to {@link Order} object.
 * @author Bence_Kornis
 */
@Component
public class OrderFacade {
    private static final String ORDERED_MESSAGE = "'{}' ordered: {}";
    private static final String DELIMITER = ", ";
    private static final String UNIT = " pcs of ";
    private Logger logger = LoggerFactory.getLogger(OrderFacade.class);

    /**
     * Saves {@link Order}.
     * @param order the {@link Order} to save
     */
    public void saveOrder(Order order) {
        String orderedAmountMessage = order.getOrderedAmounts()
                .stream()
                .filter(a -> a.getAmount() != 0)
                .map(a -> a.getAmount() + UNIT + a.getType())
                .collect(Collectors.joining(DELIMITER));
        logger.info(ORDERED_MESSAGE, order.getEmail(), orderedAmountMessage);
    }

    @VisibleForTesting
    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
