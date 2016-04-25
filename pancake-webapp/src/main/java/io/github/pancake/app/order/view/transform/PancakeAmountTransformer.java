package io.github.pancake.app.order.view.transform;

import org.springframework.stereotype.Component;

import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Transformer class to transform
 * {@link io.github.pancake.app.domain.PancakeAmount}
 * to {@link PancakeAmount}
 * @author Bence_Kornis
 */
@Component
public class PancakeAmountTransformer {
    public PancakeAmount transform(io.github.pancake.app.domain.PancakeAmount pancakeAmount) {
        return PancakeAmount.builder()
                .withType(pancakeAmount.getType())
                .withAmount(pancakeAmount.getAmount())
                .build();
    }
}
