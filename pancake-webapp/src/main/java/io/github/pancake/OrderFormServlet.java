package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.pancake.persistence.base.Pancake;

/**
 * Servlet implementation class OrderFormServlet
 * @author Adorjan Nagy
 */
@WebServlet("/OrderFormServlet")
public class OrderFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("OrderablePancakeListProviderServlet").include(request, response);
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Pancake Order Form</h1>");
        out.println("<form action='" + request.getRequestURI() + "' method='POST'>");
        out.println("Your e-mail address: <input type='text' name='eMailAddress'><br />");
        for (Pancake pancake : (List<Pancake>)request.getAttribute("orderablePancakeList")) {
            out.println(String.format("%s: <input type='text' name='%s'> pieces<br />", pancake, pancake));
        }
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
