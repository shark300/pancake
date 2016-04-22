package io.github.pancake.app.order.view.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.github.pancake.app.domain.PancakeAmount;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.service.pancake.facade.PancakeFacade;

/**
 * Validator for {@link OrderRequest}.
 * @author Bence_Kornis
 */
@Component
public class OrderRequestValidator implements Validator {
    @Autowired
    private PancakeFacade pancakeFacade;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderRequest.class.equals(clazz);
    }

    /**
     * Validates order. Validation succeeded only if sum of
     * ordered amounts lower or equal than ordering limit.
     */
    @Override
    public void validate(Object target, Errors errors) {
        int orderLimit = pancakeFacade.getOrderLimit();
        int orderedAmount = countOrderedAmount((OrderRequest) target);
        if (orderedAmount > orderLimit) {
            errors.rejectValue("orderedAmounts", "LimitExceeded", new Object[]{orderedAmount, orderLimit}, "");
        }
    }

    private int countOrderedAmount(OrderRequest request) {
        int orderedAmount = 0;
        for (PancakeAmount pancakeAmount : request.getOrderedAmounts()) {
            orderedAmount += pancakeAmount.getAmount();
        }
        return orderedAmount;
    }
}
