package io.github.pancake.app.order.view.controller;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.app.order.view.support.OrderFormModelBuilder;
import io.github.pancake.app.order.view.support.OrderRequestValidator;
import io.github.pancake.app.order.view.transform.OrderRequestTransformer;
import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.order.facade.OrderFacade;

/**
 * Test class for {@link OrderPostController}.
 * @author Bence_Kornis
 */
public class OrderPostControllerTest {
    private static final String ORDER_REQUEST = "orderRequest";
    private static final String REDIRECT_TO_CONFIRMATION = "redirect:confirmation.html";
    private static final String ORDER = "order";
    @InjectMocks
    private OrderPostController underTest;
    @Mock
    private OrderFormModelBuilder mockOrderFormModelBuilder;
    @Mock
    private OrderRequestValidator mockOrderRequestValidator;
    @Mock
    private OrderRequestTransformer mockOrderRequestTransformer;
    @Mock
    private OrderFacade mockOrderFacade;
    @Mock
    private BindingResult mockBindingResult;
    @Mock
    private RedirectAttributes mockRedirectAttributes;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testCreateOrderModelShouldReturnOrderFormModelWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.createOrderModel();
        // THEN
        verify(mockOrderFormModelBuilder).getOrderFormModel();
    }

    @Test
    public void testOrderShouldRedirectToOrderPageWhenBindingResultHasErrors() {
        // GIVEN
        OrderRequest orderRequest = new OrderRequest();
        when(mockBindingResult.hasErrors()).thenReturn(true);
        // WHEN
        String result = underTest.order(orderRequest, mockBindingResult, mockRedirectAttributes);
        // THEN
        verify(mockOrderRequestValidator, only()).validate(orderRequest, mockBindingResult);
        assertEquals(result, ORDER);
    }

    @Test
    public void testOrderShouldSaveOrderWithFacadeMethodWhenBindingResultHasNoErrors() {
        // GIVEN
        OrderRequest orderRequest = new OrderRequest();
        when(mockBindingResult.hasErrors()).thenReturn(false);
        // WHEN
        String result = underTest.order(orderRequest, mockBindingResult, mockRedirectAttributes);
        // THEN
        verify(mockOrderRequestValidator, only()).validate(orderRequest, mockBindingResult);
        verify(mockRedirectAttributes, only()).addFlashAttribute(ORDER_REQUEST, orderRequest);
        Order order = verify(mockOrderRequestTransformer, only()).transformOrderRequest(orderRequest);
        verify(mockOrderFacade, only()).saveOrder(order);
        assertEquals(result, REDIRECT_TO_CONFIRMATION);
    }
}
