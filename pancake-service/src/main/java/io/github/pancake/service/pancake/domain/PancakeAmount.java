package io.github.pancake.service.pancake.domain;

import io.github.pancake.persistence.base.Pancake;

/**
 * Contains pancake type and ordered amount.
 * @author Bence_Kornis
 */
public final class PancakeAmount {
    private Pancake type;
    private int amount;

    private PancakeAmount(Builder builder) {
        this.type = builder.type;
        this.amount = builder.amount;
    }

    public Pancake getType() {
        return type;
    }

    public int getAmount() {
        return amount;
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
