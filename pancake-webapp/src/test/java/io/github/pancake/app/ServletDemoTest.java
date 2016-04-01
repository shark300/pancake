package io.github.pancake.app;

import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.service.PancakeService;

/**
 * Test class for {@link ServletDemo}
 *
 * @author Bence_Kornis
 */
public class ServletDemoTest {
    @InjectMocks
    private ServletDemo underTest;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private PrintWriter mockPrintWriter;
    @Mock
    private PancakeService mockPancakeService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGetShouldPrintStaticContentWhenInvoked() throws Exception {
        // GIVEN
        Mockito.when(mockResponse.getWriter()).thenReturn(mockPrintWriter);
        Mockito.when(mockPancakeService.getAccessiblePancakeTypes()).thenReturn(Collections.emptyList());

        // WHEN
        underTest.doGet(mockRequest, mockResponse);

        // THEN
        Mockito.verify(mockPrintWriter, Mockito.atLeastOnce()).println(Mockito.anyString());
    }
}
