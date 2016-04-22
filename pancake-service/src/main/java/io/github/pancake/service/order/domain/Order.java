package io.github.pancake.service.order.domain;

import java.util.List;

import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Contains user email and ordered pancake amounts.
 * @author Bence_Kornis
 */
public class Order {
    private List<PancakeAmount> orderedAmounts;
    private String email;

    public List<PancakeAmount> getOrderedAmounts() {
        return orderedAmounts;
    }

    public void setOrderedAmounts(List<PancakeAmount> orderedAmounts) {
        this.orderedAmounts = orderedAmounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Order(Builder builder) {
        this.orderedAmounts = builder.orderedAmounts;
        this.email = builder.email;
    }

    public static class Builder {
        private List<PancakeAmount> orderedAmounts;
        private String email;

        public Builder withOrderedAmounts(List<PancakeAmount> orderedAmounts) {
            this.orderedAmounts = orderedAmounts;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
