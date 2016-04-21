package io.github.pancake.app.order.view.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.github.pancake.app.domain.PancakeAmount;
import io.github.pancake.app.order.view.model.OrderRequest;

@Component
public class OrderRequestValidator implements Validator {
    @Value("${order.limit}")
    private int orderLimit;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderRequest request = (OrderRequest) target;
        int orderedAmount = countOrderedAmount(request);
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
