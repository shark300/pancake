package io.github.pancake.app.order.view.transform;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.app.domain.PancakeAmount;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.order.domain.Order;

/**
 * Test class for {@link OrderRequestTransformer}.
 * @author Bence_Kornis
 */
public class OrderRequestTransformerTest {
    private static final String EMAIL = "email";
    @InjectMocks
    private OrderRequestTransformer underTest;
    @Mock
    private PancakeAmountTransformer mockPancakeAmountTransformer;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testTransformOrderRequestShouldReturnTransformedOrderWhenInvoked() {
        // GIVEN
        OrderRequest orderRequest = new OrderRequest();
        PancakeAmount amount1 = new PancakeAmount.Builder()
                .withType(Pancake.CINNAMON)
                .withAmount(1)
                .build();
        PancakeAmount amount2 = new PancakeAmount.Builder()
                .withType(Pancake.COCOA)
                .withAmount(1)
                .build();
        orderRequest.setOrderedAmounts(Arrays.asList(amount1, amount2));
        orderRequest.setEmail(EMAIL);
        // WHEN
        Order result = underTest.transformOrderRequest(orderRequest);
        // THEN
        verify(mockPancakeAmountTransformer).transform(amount1);
        verify(mockPancakeAmountTransformer).transform(amount2);
        assertEquals(result.getEmail(), EMAIL);
        assertEquals(result.getOrderedAmounts().size(), orderRequest.getOrderedAmounts().size());
    }
}
