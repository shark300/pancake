package io.github.pancake.app.order.view.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.app.order.view.support.OrderFormModelBuilder;

/**
 * Test class for {@link OrderFormController}.
 * @author Bence_Kornis
 */
public class OrderFormControllerTest {
    private static final String ORDER = "order";
    @InjectMocks
    private OrderFormController underTest;
    @Mock
    private OrderFormModelBuilder mockOrderFormModelBuilder;

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
    public void testOrderShouldRedirectToOrderPageWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        String result = underTest.order();
        // THEN
        assertEquals(result, ORDER);
    }
}
