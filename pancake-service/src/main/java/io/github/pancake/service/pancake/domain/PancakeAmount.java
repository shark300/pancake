package io.github.pancake.service.pancake.domain;

import io.github.pancake.persistence.base.Pancake;

/**
 * Contains pancake type and ordered amount.
 * @author Bence_Kornis
 */
public class PancakeAmount {
    private Pancake type;
    private int amount;

    public Pancake getType() {
        return type;
    }

    public void setType(Pancake type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private PancakeAmount(Builder builder) {
        this.type = builder.type;
        this.amount = builder.amount;
    }

    public static class Builder {
        private Pancake type;
        private int amount;

        public Builder withType(Pancake type) {
            this.type = type;
            return this;
        }

        public Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public PancakeAmount build() {
            return new PancakeAmount(this);
        }
    }
}
