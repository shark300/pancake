package io.github.pancake.app.order.view.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pancake.app.order.view.model.OrderFormModel;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.pancake.facade.PancakeFacade;

/**
 * Builder for {@link OrderFormModel} class.
 * Provides {@link io.github.pancake.app.order.view.controller.OrderFormController} and
 * {@link io.github.pancake.app.order.view.controller.OrderPostController}.
 * @author Bence_Kornis
 */
@Component
public class OrderFormModelBuilder {
    @Autowired
    private PancakeFacade pancakeFacade;

    /**
     * Initialize {@link OrderFormModel}.
     * Contains available amounts of ordering and available pancake types
     * @return the {@link OrderFormModel}
     */
    public OrderFormModel getOrderFormModel() {
        return OrderFormModel.builder()
                .withAvailableAmounts(initAvailableAmounts())
                .withAvailablePancakes(initAvailablePancakes())
                .build();
    }

    private List<Integer> initAvailableAmounts() {
        return pancakeFacade.getAvailableAmounts();
    }

    private List<Pancake> initAvailablePancakes() {
        return pancakeFacade.getOrderablePancakes();
    }
}
