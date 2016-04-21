package io.github.pancake.app.order.view.model;

import java.util.List;

import io.github.pancake.persistence.base.Pancake;

public class OrderFormModel {
    private List<Integer> availableAmounts;
    private List<Pancake> availablePancakes;

    public OrderFormModel(List<Integer> availableAmounts, List<Pancake> availablePancakes) {
        this.availableAmounts = availableAmounts;
        this.availablePancakes = availablePancakes;
    }

    public List<Integer> getAvailableAmounts() {
        return availableAmounts;
    }

    public List<Pancake> getAvailablePancakes() {
        return availablePancakes;
    }
}
