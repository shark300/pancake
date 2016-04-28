package io.github.pancake.app.order.view.transform;

import org.springframework.stereotype.Component;

import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Transformer class.
 * Transforms {@link io.github.pancake.app.domain.PancakeAmount}
 * to {@link PancakeAmount}
 * @author Bence_Kornis
 */
@Component
public class PancakeAmountTransformer {
    /**
     * The transform method.
     * @param pancakeAmount the {@link io.github.pancake.app.domain.PancakeAmount} to be transformed
     * @return the {@link PancakeAmount}
     */
    public PancakeAmount transform(io.github.pancake.app.domain.PancakeAmount pancakeAmount) {
        return PancakeAmount.builder()
                .withType(pancakeAmount.getType())
                .withAmount(pancakeAmount.getAmount())
                .build();
    }
}
