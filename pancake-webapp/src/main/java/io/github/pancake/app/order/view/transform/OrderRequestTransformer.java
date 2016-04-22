package io.github.pancake.app.order.view.transform;

import java.util.List;

import org.springframework.stereotype.Component;

import io.github.pancake.app.domain.support.ListConverter;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Transforms {@link OrderRequest} to {@link Order}.
 * @author Bence_Kornis
 */
@Component
public class OrderRequestTransformer {
    /**
     * The transform method
     * @param orderRequest the {@link OrderRequest} to be transformed
     * @return the {@link Object}
     */
    public Order transformOrderRequest(OrderRequest orderRequest) {
        return new Order.Builder()
                .withOrderedAmounts(convertOrderedAmounts(orderRequest))
                .withEmail(orderRequest.getEmail())
                .build();
    }

    private List<PancakeAmount> convertOrderedAmounts(OrderRequest orderRequest) {
        return ListConverter.convertList(
                orderRequest.getOrderedAmounts(),
                l -> new PancakeAmount.Builder()
                        .withType(l.getType())
                        .withAmount(l.getAmount())
                        .build());
    }
}
