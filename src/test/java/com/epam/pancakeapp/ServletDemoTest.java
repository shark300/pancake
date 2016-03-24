package com.epam.pancakeapp;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for {@link ServletDemo}.
 * @author Bence Kornis
 *
 */
public class ServletDemoTest extends Mockito {
    private ServletDemo underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new ServletDemo();
    }

    @Test
    public void testServlet() throws Exception {
        // GIVEN
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // WHEN
        when(response.getWriter()).thenReturn(printWriter);
        underTest.doGet(request, response);

        // THEN
        Assert.assertEquals(stringWriter.toString(), "<html>\r\n<body>\r\n<h1>Pancake</h1>\r\n</body>\r\n</html>\r\n");
    }
}
