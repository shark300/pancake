package io.github.pancake;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.facade.PancakeFacade;

/**
 * Test class for {@link OrderControllerServlet}.
 * @author Bence Kornis
 *
 */
public class OrderServletTest {
    private OrderControllerServlet underTest;
    @Mock
    private PancakeFacade mockPancakeFacade;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;
    @Mock
    private Logger mockLogger;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new OrderControllerServlet();
    }

    @Test
    public void testDoGetShouldPrintStaticContentWhenInvoked() throws Exception {
        // GIVEN
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).println(Mockito.anyString());
    }

    @Test
    public void testDoPostShouldPrintStaticContentWhenInvoked() throws Exception {
        // GIVEN
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        // WHEN
        underTest.doPost(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).println(Mockito.anyString());
    }

    @Test
    public void testDoPostShouldWriteIntoLogWhenInvoked() throws Exception {
        // GIVEN
        underTest.setLogger(mockLogger);
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        when(mockRequest.getParameter("e_mail_address")).thenReturn("e_mail_address");
        // WHEN
        underTest.doPost(mockRequest, mockResponse);
        // THEN
        verify(mockLogger, atLeastOnce()).info(Mockito.anyString());
    }
}
