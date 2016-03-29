package io.github.pancake.servlet;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit test of {@link PancakeServlet}
 * 
 * @author Adorjan Nagy
 */
public class PancakeServletTest {

    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;

    private PancakeServlet underTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PancakeServlet();
    }

    @Test
    public void testDoGetShouldAlwaysSendTheSameHTML() throws IOException {
        // GIVEN
        when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        // WHEN
        underTest.doGet(mockRequest, mockResponse);
        // THEN
        verify(mockPrintWriter, atLeastOnce()).print(anyString());
    }
}
