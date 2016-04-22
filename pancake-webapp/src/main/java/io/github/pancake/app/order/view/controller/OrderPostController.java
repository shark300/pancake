package io.github.pancake.app.order.view.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.pancake.app.order.view.model.OrderFormModel;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.app.order.view.support.OrderFormModelBuilder;
import io.github.pancake.app.order.view.support.OrderRequestValidator;
import io.github.pancake.app.order.view.transform.OrderRequestTransformer;
import io.github.pancake.service.order.facade.OrderFacade;

/**
 * Controller class for the order form page POST method.
 * @author Bence_Kornis
 */
@Controller
public class OrderPostController {
    public static final String REQUEST_MAPPING = "/orderPost.html";
    @Autowired
    private OrderFormModelBuilder orderFormModelBuilder;
    @Autowired
    private OrderRequestValidator orderRequestValidator;
    @Autowired
    private OrderRequestTransformer orderRequestTransformer;
    @Autowired
    private OrderFacade orderFacade;

    @ModelAttribute("orderRequest")
    public OrderRequest createOrderModel(@ModelAttribute OrderRequest orderRequest) {
        return new OrderRequest();
    }

    @ModelAttribute("orderFormModel")
    public OrderFormModel createOrderModel() {
        return orderFormModelBuilder.getOrderFormModel();
    }

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
    private String order(@Valid @ModelAttribute("orderRequest") OrderRequest orderRequest,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        orderRequestValidator.validate(orderRequest, bindingResult);

        String result;
        if (bindingResult.hasErrors()) {
            result = "order";
        } else {
            saveOrder(orderRequest);
            redirectAttributes.addFlashAttribute("orderRequest", orderRequest);
            result = "redirect:confirmation.html";
        }
        return result;
    }

    private void saveOrder(OrderRequest orderRequest) {
        orderFacade.saveOrder(orderRequestTransformer.transformOrderRequest(orderRequest));
    }
}
