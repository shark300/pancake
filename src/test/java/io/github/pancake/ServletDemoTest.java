package io.github.pancake;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for {@link ServletDemo}.
 * @author Bence Kornis
 *
 */
public class ServletDemoTest {
    private ServletDemo underTest;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;

    @BeforeMethod
    public void setUp() {
        underTest = new ServletDemo();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGetShouldPrintStaticContentWhenInvoked() throws Exception {
        // GIVEN
        Mockito.when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

        // WHEN
        underTest.doGet(mockRequest, mockResponse);

        // THEN
        Mockito.verify(mockPrintWriter, Mockito.atLeastOnce()).println(Mockito.anyString());
    }
}
