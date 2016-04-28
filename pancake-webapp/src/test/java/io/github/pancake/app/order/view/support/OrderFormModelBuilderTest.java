package io.github.pancake.app.order.view.support;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.service.pancake.facade.PancakeFacade;

/**
 * Test class for {@link OrderFormModelBuilder}.
 * @author Bence_Kornis
 */
public class OrderFormModelBuilderTest {
    @InjectMocks
    private OrderFormModelBuilder underTest;
    @Mock
    private PancakeFacade mockPancakeFacade;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetOrderFormModelShouldInvokeFacadeMethodsWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.getOrderFormModel();
        // THEN
        verify(mockPancakeFacade).getAvailableAmounts();
        verify(mockPancakeFacade).getOrderablePancakes();
    }
}
