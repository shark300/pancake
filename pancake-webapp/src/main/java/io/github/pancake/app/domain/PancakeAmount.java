package io.github.pancake.app.domain;

import io.github.pancake.persistence.base.Pancake;

/**
 * Contains pancake type and ordered amount.
 * @author Bence_Kornis
 */
public class PancakeAmount {
    private Pancake type;
    private int amount;

    public PancakeAmount() {
    }

    private PancakeAmount(Builder builder) {
        this.type = builder.type;
        this.amount = builder.amount;
    }

    public PancakeAmount(Pancake type, int amount) {
        this.type = type;
        this.amount = amount;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Pancake type;
        private int amount;

        private Builder() {
        }

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
