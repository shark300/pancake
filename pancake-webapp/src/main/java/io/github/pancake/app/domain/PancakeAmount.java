package io.github.pancake.app.domain;

import io.github.pancake.persistence.base.Pancake;

public class PancakeAmount {
    private Pancake type;
    private int amount;

    public PancakeAmount() {}

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
}
