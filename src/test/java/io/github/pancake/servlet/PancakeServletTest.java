package io.github.pancake.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Adorjan Nagy
 *
 */
public class PancakeServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;

    private PancakeServlet underTest;
    private String PancakeServletResponseHtml;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PancakeServlet();
        StringBuilder sb = new StringBuilder(8);
        sb.append("<html>");
        sb.append("<head>");
        sb.append("  <meta charset='UTF-8'>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("  Stop, Pancake time!");
        sb.append("</body>");
        sb.append("</html>");
        PancakeServletResponseHtml = sb.toString();
    }

    @Test
    public void testDoGetShouldAlwaysSendTheSameHTML() throws IOException {
        // GIVEN
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        // WHEN
        underTest.doGet(request, response);
        // THEN
        assertEquals("requested resource", stringWriter.toString(), PancakeServletResponseHtml);
    }
}
