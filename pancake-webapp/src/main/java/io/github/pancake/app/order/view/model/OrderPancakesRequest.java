package io.github.pancake.app.order.view.model;

import java.util.List;

public class OrderPancakesRequest {
    private List<OrderElement> orderedAmounts;
    private String email;

//    public OrderPancakesRequest(List<OrderElement> orderedAmounts, String email) {
//        this.orderedAmounts = orderedAmounts;
//        this.email = email;
//    }

    public List<OrderElement> getOrderedAmounts() {
        return orderedAmounts;
    }

    public String getEmail() {
        return email;
    }
}
