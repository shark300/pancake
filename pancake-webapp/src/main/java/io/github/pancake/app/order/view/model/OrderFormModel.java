package io.github.pancake.app.order.view.model;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import io.github.pancake.app.order.view.controller.OrderFormController;
import io.github.pancake.app.order.view.controller.OrderPostController;
import io.github.pancake.persistence.base.Pancake;

/**
 * {@link ModelAttribute} provider class for {@link OrderFormController} and {@link OrderPostController}.
 * @author Bence_Kornis
 */
public class OrderFormModel {
    private List<Integer> availableAmounts;
    private List<Pancake> availablePancakes;

    public List<Integer> getAvailableAmounts() {
        return availableAmounts;
    }

    public List<Pancake> getAvailablePancakes() {
        return availablePancakes;
    }

    private OrderFormModel(Builder builder) {
        this.availableAmounts = builder.availableAmounts;
        this.availablePancakes = builder.availablePancakes;
    }

    public static class Builder {
        private List<Integer> availableAmounts;
        private List<Pancake> availablePancakes;

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
