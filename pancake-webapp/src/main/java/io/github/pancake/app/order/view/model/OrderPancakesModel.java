package io.github.pancake.app.order.view.model;

import java.util.List;

public class OrderPancakesModel {
    private List<Integer> orderAmounts;
    private List<OrderElement> orderedPancakes;

    public OrderPancakesModel(List<Integer> orderAmounts, List<OrderElement> orderedPancakes) {
        this.orderAmounts = orderAmounts;
        this.orderedPancakes = orderedPancakes;
    }

    public List<Integer> getOrderAmounts() {
        return orderAmounts;
    }

    public List<OrderElement> getOrderedPancakes() {
        return orderedPancakes;
    }
}
