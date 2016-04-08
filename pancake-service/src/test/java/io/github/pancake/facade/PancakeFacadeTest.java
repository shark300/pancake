package io.github.pancake.facade;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.factory.PancakeFactory;
import io.github.pancake.service.PancakeService;

/**
 * Test class for {@link PancakeFacade}.
 *
 * @author Adorjan Nagy
 */
public class PancakeFacadeTest {
    private PancakeFacade underTest;
    @Mock
    private PancakeService mockPancakeService;
    @Mock
    private PancakeFactory mockPancakeFactory;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PancakeFacade(mockPancakeService, mockPancakeFactory);
    }

    @Test
    public void testGetOrderablePancakesShouldReceiveAListOfPancakesViaPancakeServiceWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.getOrderablePancakes();
        // THEN
        verify(mockPancakeFactory, only()).getObject();
    }
}
