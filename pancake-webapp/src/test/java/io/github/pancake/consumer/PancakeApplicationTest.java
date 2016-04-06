package io.github.pancake.consumer;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.service.PancakeService;

/**
 * Test class for {@link PancakeApplication}.
 *
 * @author Adorjan Nagy
 */
public class PancakeApplicationTest {
    private PancakeApplication underTest;
    @Mock
    private PancakeService mockPancakeService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PancakeApplication();
    }

    @Test
    public void testGetOrderablePancakesShouldReceiveAListOfPancakesViaPancakeServiceWhenInvoked() {
        // GIVEN
        underTest.setService(mockPancakeService);

        // WHEN
        underTest.getOrderablePancakes();

        // THEN
        verify(mockPancakeService, only()).getOrderablePancakes();
    }
}
