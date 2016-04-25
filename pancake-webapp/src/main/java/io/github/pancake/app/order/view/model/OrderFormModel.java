package io.github.pancake.app.order.view.model;

import java.util.List;

import io.github.pancake.persistence.base.Pancake;

/**
 * {@link org.springframework.web.bind.annotation.ModelAttribute} provider class for
 * {@link io.github.pancake.app.order.view.controller.OrderFormController} and
 * {@link io.github.pancake.app.order.view.controller.OrderPostController}.
 * @author Bence_Kornis
 */
public class OrderFormModel {
    private List<Integer> availableAmounts;
    private List<Pancake> availablePancakes;

    private OrderFormModel(Builder builder) {
        this.availableAmounts = builder.availableAmounts;
        this.availablePancakes = builder.availablePancakes;
    }

    public List<Integer> getAvailableAmounts() {
        return availableAmounts;
    }

    public List<Pancake> getAvailablePancakes() {
        return availablePancakes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Integer> availableAmounts;
        private List<Pancake> availablePancakes;

        private Builder() {
        }

        public Builder withAvailableAmounts(List<Integer> availableAmounts) {
            this.availableAmounts = availableAmounts;
            return this;
        }

        public Builder withAvailablePancakes(List<Pancake> availablePancakes) {
            this.availablePancakes = availablePancakes;
            return this;
        }

        public OrderFormModel build() {
            return new OrderFormModel(this);
        }
    }
}
