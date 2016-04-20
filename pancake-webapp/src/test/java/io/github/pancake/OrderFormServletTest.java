package io.github.pancake;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.facade.PancakeFacade;
import io.github.pancake.persistence.base.Pancake;

/**
 * Test class for {@link OrderFormServlet}.
 *
 * @author Adorjan Nagy
 */
public class OrderFormServletTest {
    private OrderFormServlet underTest;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;
    @Mock
    private PancakeFacade mockPancakeFacade;
    @Mock
    private List<Pancake> testPancakes;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new OrderFormServlet();
        testPancakes = Arrays.asList(Pancake.values());
    }

    @Test
    public void testDoGetShouldWriteIntoPrintWriterWhenInvoked() throws IOException {
        // GIVEN
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        underTest.setPancakeFacade(mockPancakeFacade);
        when(mockPancakeFacade.getOrderablePancakes()).thenReturn(testPancakes);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).println(Mockito.anyString());
    }
}
