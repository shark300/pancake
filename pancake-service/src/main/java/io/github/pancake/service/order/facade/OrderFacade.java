package io.github.pancake.service.order.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Facade containing methods related to {@link Order} object.
 * @author Bence_Kornis
 */
@Component
public class OrderFacade {
    private Logger logger = LoggerFactory.getLogger(OrderFacade.class);

    /**
     * Saves {@link Order}
     * @param order the {@link Order} to save
     */
    public void saveOrder(Order order) {
        String orderedAmountsMessage = createOrderedAmountsMessage(order.getOrderedAmounts());
        if (!orderedAmountsMessage.isEmpty()) {
            logger.info("'{}' ordered: {}", order.getEmail(), orderedAmountsMessage);
        }
    }

    private String createOrderedAmountsMessage(List<PancakeAmount> orderedAmounts) {
        StringBuilder builder = new StringBuilder();
        for (PancakeAmount pancakeAmount : orderedAmounts) {
            if (pancakeAmount.getAmount() != 0) {
                if (builder.length() != 0) {
                    builder.append(", ");
                }
                builder.append(pancakeAmount.getAmount())
                        .append(" pcs of ")
                        .append(pancakeAmount.getType());
            }
        }
        return builder.toString();
    }

    @VisibleForTesting
    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
