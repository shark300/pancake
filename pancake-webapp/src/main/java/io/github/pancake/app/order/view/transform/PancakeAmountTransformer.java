package io.github.pancake.app.order.view.transform;

import org.springframework.stereotype.Component;

import io.github.pancake.service.pancake.domain.PancakeAmount;

@Component
public class PancakeAmountTransformer {
    public PancakeAmount transform(io.github.pancake.app.domain.PancakeAmount pancakeAmount) {
        return new PancakeAmount.Builder()
                .withType(pancakeAmount.getType())
                .withAmount(pancakeAmount.getAmount())
                .build();
    }
}
