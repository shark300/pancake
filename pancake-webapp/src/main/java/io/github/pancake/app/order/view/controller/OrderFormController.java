package io.github.pancake.app.order.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.pancake.app.order.view.model.OrderFormModel;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.app.order.view.model.builder.OrderFormModelBuilder;

@Controller
public class OrderFormController {
    public static final String REQUEST_MAPPING = "/orderForm.html";
    @Autowired
    private OrderFormModelBuilder orderFormModelBuilder;

    @ModelAttribute("orderRequest")
    public OrderRequest createOrderModel(@ModelAttribute OrderRequest orderRequest) {
        return new OrderRequest();
    }

    @ModelAttribute("orderFormModel")
    public OrderFormModel createOrderModel() {
        return orderFormModelBuilder.getOrderFormModel();
    }

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    private String order() {
        return "order";
    }
}
