package io.github.pancake.app.order.view.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.pancake.app.order.view.model.OrderElement;
import io.github.pancake.app.order.view.model.OrderPancakesModel;
import io.github.pancake.app.order.view.model.OrderPancakesRequest;
import io.github.pancake.persistence.base.Pancake;

@Controller
public class OrderPancakesFormController {
    public static final String REQUEST_MAPPING = "/orderPancakesForm.html";

    @ModelAttribute("orderPancakesRequest")
    public OrderPancakesRequest createListBooksModel(@ModelAttribute OrderPancakesRequest orderPancakesRequest) {
//        List<OrderElement> orderedAmounts = new ArrayList<>();
//        for (Pancake pancake : Pancake.values()) {
//            orderedAmounts.add(new OrderElement(pancake, 0));
//        }
//        return new OrderPancakesRequest(orderedAmounts, "");
        return new OrderPancakesRequest();
    }

    @ModelAttribute("orderPancakesForm")
    public OrderPancakesModel createListBooksModel() {
        List<OrderElement> orderedAmounts = new ArrayList<>();
        for (Pancake pancake : Pancake.values()) {
            orderedAmounts.add(new OrderElement(pancake, 0));
        }
        List<Integer> orderAmounts = new ArrayList<>(Arrays.asList(0, 1, 2));
        return new OrderPancakesModel(orderAmounts, orderedAmounts);
    }

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    private String orderPancakes() {
        return "order";
    }
}
