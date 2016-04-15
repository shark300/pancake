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
import javax.servlet.http.HttpSession;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.facade.PancakeFacade;
import io.github.pancake.persistence.base.Pancake;

/**
 * Test class for {@link OrderConfirmationServlet}.
 *
 * @author Adorjan Nagy
 */
public class OrderConfirmationServletTest {
    private OrderConfirmationServlet underTest;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private HttpSession mockSession;
    @Mock
    private PrintWriter mockPrintWriter;
    private String pancakesWithAmounts;
    @Mock
    private PancakeFacade mockPancakeFacade;
    private List<Pancake> pancakes;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new OrderConfirmationServlet();
        pancakesWithAmounts = "2 COCOA";
        pancakes = Arrays.asList(Pancake.values());
    }

    @Test
    public void testDoGetShouldWriteIntoPrintWriterWhenInvoked() throws IOException {
        // GIVEN
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        when(mockSession.getAttribute("pancakesWithAmounts")).thenReturn(pancakesWithAmounts);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).println(Mockito.anyString());
    }

    @Test
    public void testDoPostShouldWriteIntoPrintWriterWhenInvoked() throws IOException {
        // GIVEN
        when(mockPancakeFacade.getOrderablePancakes()).thenReturn(pancakes);
        underTest.setPancakeFacade(mockPancakeFacade);
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        // WHEN
        underTest.doPost(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).println(Mockito.anyString());
    }
}
