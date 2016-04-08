package io.github.pancake;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.facade.PancakeFacade;

/**
 * Test class for {@link ServletDemo}.
 * @author Bence Kornis
 *
 */
public class ServletDemoTest {
    private ServletDemo underTest;
    @Mock
    private PancakeFacade mockPancakeFacade;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new ServletDemo();
        underTest.setPancakeFacade(mockPancakeFacade);
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
}
