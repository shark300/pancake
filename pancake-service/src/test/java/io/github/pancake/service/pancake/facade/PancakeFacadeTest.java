package io.github.pancake.service.pancake.facade;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.service.pancake.factory.PancakeFactory;

/**
 * Test class for {@link PancakeFacade}.
 *
 * @author Adorjan Nagy
 * @author Bence_Kornis
 */
public class PancakeFacadeTest {
    private PancakeFacade underTest;
    @Mock
    private PancakeFactory mockPancakeFactory;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new PancakeFacade(mockPancakeFactory);
    }

    @Test
    public void testGetOrderablePancakesShouldReceiveAListOfPancakesViaPancakeServiceWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.getOrderablePancakes();
        // THEN
        verify(mockPancakeFactory, only()).getObject();
    }

    @Test
    public void testGetAvailableAmountsShouldReturnListWithIntegersWhenInvokedWithNonNegativeOrderLimit() {
        // GIVEN
        int orderLimit = 2;
        underTest.setOrderLimit(orderLimit);
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i <= orderLimit; i++) {
            testList.add(i);
        }
        // WHEN
        List<Integer> availableAmounts = underTest.getAvailableAmounts();
        // THEN
        assertEquals(availableAmounts.size(), testList.size());
        assertTrue(availableAmounts.containsAll(testList));
    }

    @Test
    public void testGetAvailableAmountsShouldReturnEmptyListWhenInvokedWithNegativeOrderLimit() {
        // GIVEN
        int orderLimit = -1;
        underTest.setOrderLimit(orderLimit);
        // WHEN
        List<Integer> availableAmounts = underTest.getAvailableAmounts();
        // THEN
        assertTrue(availableAmounts.isEmpty());
    }
}