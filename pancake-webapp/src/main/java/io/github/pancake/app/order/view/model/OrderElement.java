package io.github.pancake.app.order.view.model;

import io.github.pancake.persistence.base.Pancake;

public class OrderElement {
    private Pancake type;
    private int amount;

    public OrderElement(Pancake type, int amount) {
        super();
        this.type = type;
        this.amount = amount;
    }

    public Pancake getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
