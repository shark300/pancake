package io.github.pancake.service.order.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Facade containing methods related to {@link Order} object.
 * @author Bence_Kornis
 */
@Component
public class OrderFacade {
    private Logger logger = LoggerFactory.getLogger(OrderFacade.class);

    public void saveOrder(Order order) {
        for (PancakeAmount pancakeAmount : order.getOrderedAmounts()) {
            if (pancakeAmount.getAmount() != 0) {
                logger.info(createLogMessage(order.getEmail(), pancakeAmount));
            }
        }
    }

    private String createLogMessage(String email, PancakeAmount pancakeAmount) {
        return new StringBuilder("'")
                .append(email)
                .append("' ordered ")
                .append(pancakeAmount.getAmount())
                .append(" pcs of ")
                .append(pancakeAmount.getType())
                .append(" pancake")
                .toString();
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
