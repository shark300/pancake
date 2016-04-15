package io.github.pancake;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for {@link OrderControllerServlet}.
 *
 * @author Bence Kornis
 * @author Adorjan Nagy
 */
public class OrderControllerServletTest {
    private OrderControllerServlet underTest;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private HttpSession mockSession;
    @Mock
    private Logger mockLogger;
    @Mock
    private RequestDispatcher mockRequestDispatcher;
    private String eMailAddress;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new OrderControllerServlet();
        eMailAddress = "test@test.com";
    }

    @Test
    public void testDoGetShouldIncludeOrderFormServletWhenItIsANewRequest() throws IOException, ServletException {
        // GIVEN
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute("eMailAddress")).thenReturn(null);
        when(mockRequest.getRequestDispatcher("OrderFormServlet")).thenReturn(mockRequestDispatcher);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockRequestDispatcher, only()).include(mockRequest, mockResponse);
    }

    @Test
    public void testDoGetShouldIncludeOrderConfirmationServletWhenItIsNotANewRequest() throws IOException, ServletException {
        // GIVEN
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute("eMailAddress")).thenReturn(eMailAddress);
        when(mockRequest.getRequestDispatcher("OrderConfirmationServlet")).thenReturn(mockRequestDispatcher);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockRequestDispatcher, only()).include(mockRequest, mockResponse);
    }

    @Test
    public void testDoPostShouldWriteIntoLogWhenInvoked() throws Exception {
        // GIVEN
        when(mockRequest.getRequestDispatcher("OrderConfirmationServlet")).thenReturn(mockRequestDispatcher);
        when(mockRequest.getSession()).thenReturn(mockSession);
        underTest.setLogger(mockLogger);
        // WHEN
        underTest.doPost(mockRequest, mockResponse);
        // THEN
        verify(mockLogger, atLeastOnce()).info(Mockito.anyString());
    }
}
