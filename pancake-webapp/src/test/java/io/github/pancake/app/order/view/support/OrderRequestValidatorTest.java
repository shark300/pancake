package io.github.pancake.app.order.view.support;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.app.domain.PancakeAmount;
import io.github.pancake.app.order.view.model.OrderRequest;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.pancake.facade.PancakeFacade;

/**
 * Test class for {@link OrderRequestValidator}.
 * @author Bence_Kornis
 */
public class OrderRequestValidatorTest {
    private static final String LIMIT_EXCEEDED = "LimitExceeded";
    private static final String ORDERED_AMOUNTS = "orderedAmounts";
    @InjectMocks
    private OrderRequestValidator underTest;
    @Mock
    private PancakeFacade mockPancakeFacade;
    @Mock
    private Errors mockErrors;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testValidateShouldAddErrorWhenLimitExceeds() {
        // GIVEN
        OrderRequest orderRequest = new OrderRequest();
        PancakeAmount amount1 = new PancakeAmount.Builder()
                .withType(Pancake.CINNAMON)
                .withAmount(2)
                .build();
        PancakeAmount amount2 = new PancakeAmount.Builder()
                .withType(Pancake.COCOA)
                .withAmount(1)
                .build();
        orderRequest.setOrderedAmounts(Arrays.asList(amount1, amount2));
        when(mockPancakeFacade.getOrderLimit()).thenReturn(2);
        // WHEN
        underTest.validate(orderRequest, mockErrors);
        // THEN
        verify(mockErrors).rejectValue(ORDERED_AMOUNTS, LIMIT_EXCEEDED, new Object[]{3, 2}, "");
    }

    @Test
    public void testValidateShouldNotAddErrorWhenLimitDoNotExceeds() {
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
        when(mockPancakeFacade.getOrderLimit()).thenReturn(2);
        // WHEN
        underTest.validate(orderRequest, mockErrors);
        // THEN
        verify(mockErrors, never()).rejectValue(anyString(), anyString(), any(), anyString());
    }
}
