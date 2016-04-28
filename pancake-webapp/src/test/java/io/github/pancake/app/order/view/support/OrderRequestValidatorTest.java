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
    private static final String EMPTY_ORDER = "EmptyOrder";
    private static final String LIMIT_EXCEEDED = "LimitExceeded";
    private static final String ORDERED_AMOUNTS = "orderedAmounts";
    @InjectMocks
    private OrderRequestValidator underTest;
    @Mock
    private PancakeFacade mockPancakeFacade;
    @Mock
    private Errors mockErrors;
    private OrderRequest orderRequest;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        orderRequest = new OrderRequest();
    }

    @Test
    public void testValidateShouldAddErrorWhenLimitExceeds() {
        // GIVEN
        PancakeAmount cinnamonAmount = createPancakeAmount(Pancake.CINNAMON, 2);
        PancakeAmount cocoaAmount = createPancakeAmount(Pancake.COCOA, 1);
        orderRequest.setOrderedAmounts(Arrays.asList(cinnamonAmount, cocoaAmount));
        when(mockPancakeFacade.getOrderLimit()).thenReturn(2);
        // WHEN
        underTest.validate(orderRequest, mockErrors);
        // THEN
        verify(mockErrors).rejectValue(ORDERED_AMOUNTS, LIMIT_EXCEEDED, new Object[]{3, 2}, "");
    }

    @Test
    public void testValidateShouldAddErrorWhenZeroAmountOrdered() {
        // GIVEN
        PancakeAmount cinnamonAmount = createPancakeAmount(Pancake.CINNAMON, 0);
        PancakeAmount cocoaAmount = createPancakeAmount(Pancake.COCOA, 0);
        orderRequest.setOrderedAmounts(Arrays.asList(cinnamonAmount, cocoaAmount));
        when(mockPancakeFacade.getOrderLimit()).thenReturn(2);
        // WHEN
        underTest.validate(orderRequest, mockErrors);
        // THEN
        verify(mockErrors).rejectValue(ORDERED_AMOUNTS, EMPTY_ORDER, "");
    }

    @Test
    public void testValidateShouldNotAddErrorWhenLimitIsNotExceeded() {
        // GIVEN
        PancakeAmount cinnamonAmount = createPancakeAmount(Pancake.CINNAMON, 1);
        PancakeAmount cocoaAmount = createPancakeAmount(Pancake.COCOA, 1);
        orderRequest.setOrderedAmounts(Arrays.asList(cinnamonAmount, cocoaAmount));
        when(mockPancakeFacade.getOrderLimit()).thenReturn(2);
        // WHEN
        underTest.validate(orderRequest, mockErrors);
        // THEN
        verify(mockErrors, never()).rejectValue(anyString(), anyString(), any(), anyString());
    }

    private PancakeAmount createPancakeAmount(Pancake type, int amount) {
        PancakeAmount pancakeAmount = PancakeAmount.builder()
                .withType(type)
                .withAmount(amount)
                .build();
        return pancakeAmount;
    }
}
