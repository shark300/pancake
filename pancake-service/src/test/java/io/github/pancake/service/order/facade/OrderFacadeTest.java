package io.github.pancake.service.order.facade;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.order.domain.Order;
import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Test class for {@link OrderFacade}.
 * @author Bence_Kornis
 */
public class OrderFacadeTest {
    private OrderFacade underTest;
    @Mock
    private Logger mockLogger;
    @Mock
    private Order mockOrder;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new OrderFacade();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testSaveOrderShouldLogOrderWhenInvoked() {
        // GIVEN
        PancakeAmount amount1 = new PancakeAmount.Builder()
                .withType(Pancake.CINNAMON)
                .withAmount(0)
                .build();
        PancakeAmount amount2 = new PancakeAmount.Builder()
                .withType(Pancake.COCOA)
                .withAmount(1)
                .build();
        when(mockOrder.getOrderedAmounts()).thenReturn(Arrays.asList(amount1, amount2));
        // WHEN
        underTest.saveOrder(mockOrder);
        // THEN
        verify(mockLogger, times(1)).info(anyString());
    }
}
