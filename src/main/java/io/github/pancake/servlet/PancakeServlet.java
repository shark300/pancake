package io.github.pancake.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Adorjan Nagy
 *
 */
public class PancakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * Always provide the same HTML content in response
     */
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("  <meta charset='UTF-8'>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("  Stop, Pancake time!");
        writer.print("</body>");
        writer.print("</html>");
    }
}
