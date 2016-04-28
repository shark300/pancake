package io.github.pancake.service.order.facade;

import static org.mockito.Mockito.verify;
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
    private static final String ORDER_MESSAGE = "'{}' ordered: {}";
    private static final String ORDERED_AMOUNTS = "1 pcs of CINNAMON, 1 pcs of COCOA";
    private static final String EMAIL = "email";
    private OrderFacade underTest;
    @Mock
    private Logger mockLogger;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new OrderFacade();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testSaveOrderShouldLogOrderWhenInvoked() {
        // GIVEN
        PancakeAmount cinnamonAmount = createPancakeAmount(Pancake.CINNAMON, 1);
        PancakeAmount cocoaAmount = createPancakeAmount(Pancake.COCOA, 1);
        Order order = Order.builder()
                .withOrderedAmounts(Arrays.asList(cinnamonAmount, cocoaAmount))
                .withEmail(EMAIL)
                .build();
        // WHEN
        underTest.saveOrder(order);
        // THEN
        verify(mockLogger).info(ORDER_MESSAGE, EMAIL, ORDERED_AMOUNTS);
    }

    private PancakeAmount createPancakeAmount(Pancake type, int amount) {
        PancakeAmount pancakeAmount = PancakeAmount.builder()
                .withType(type)
                .withAmount(amount)
                .build();
        return pancakeAmount;
    }
}
