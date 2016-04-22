package io.github.pancake.app.order.view.model;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.github.pancake.app.domain.PancakeAmount;
import io.github.pancake.app.order.view.controller.OrderFormController;
import io.github.pancake.app.order.view.controller.OrderPostController;

/**
 * {@link ModelAttribute} provider class for {@link OrderFormController} and {@link OrderPostController}.
 * @author Bence_Kornis
 */
public class OrderRequest {
    private List<PancakeAmount> orderedAmounts;
    @NotBlank
    @Email
    private String email;

    public List<PancakeAmount> getOrderedAmounts() {
        return orderedAmounts;
    }

    public void setOrderedAmounts(List<PancakeAmount> orderedAmounts) {
        this.orderedAmounts = orderedAmounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
