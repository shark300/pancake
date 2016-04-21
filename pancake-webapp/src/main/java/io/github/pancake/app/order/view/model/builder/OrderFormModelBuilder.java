package io.github.pancake.app.order.view.model.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pancake.app.order.view.model.OrderFormModel;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.facade.PancakeFacade;

@Component
public class OrderFormModelBuilder {
    @Autowired
    private PancakeFacade pancakeFacade;

    public OrderFormModel getOrderFormModel() {
        return new OrderFormModel(initAvailableAmounts(), initAvailablePancakes());
    }

    private List<Integer> initAvailableAmounts() {
        return pancakeFacade.getAvailableAmounts();
    }

    private List<Pancake> initAvailablePancakes() {
        return pancakeFacade.getOrderablePancakes();
    }
}
