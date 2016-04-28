package io.github.pancake.app.order.view.transform;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Transforms {@link OrderRequest} to {@link Order}.
 * @author Bence_Kornis
 */
@Component
public class OrderRequestTransformer {
    @Autowired
    private PancakeAmountTransformer pancakeAmountTransformer;

    /**
     * The transform method.
     * @param orderRequest the {@link OrderRequest} to be transformed
     * @return the {@link Order}
     */
    public Order transformOrderRequest(OrderRequest orderRequest) {
        return Order.builder()
                .withOrderedAmounts(transformOrderedAmounts(orderRequest))
                .withEmail(orderRequest.getEmail())
                .build();
    }

    private List<PancakeAmount> transformOrderedAmounts(OrderRequest orderRequest) {
        return orderRequest.getOrderedAmounts().stream()
                .map(a -> pancakeAmountTransformer.transform(a))
                .collect(Collectors.toList());
    }
}
