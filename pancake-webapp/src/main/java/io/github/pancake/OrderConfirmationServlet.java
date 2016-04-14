package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.github.pancake.persistence.base.Pancake;

/**
 * Servlet implementation class OrderConfirmationServlet
 */
@WebServlet("/OrderConfirmationServlet")
public class OrderConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        writeResponseHtml(response.getWriter(), (String) session.getAttribute("pancakesWithAmounts"));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("OrderablePancakeListProviderServlet").include(request, response);
        Map<Pancake, String> pancakeOrder = createPancakeOrder(request);
        String pancakesWithAmounts = "";
        for (Pancake pancake : pancakeOrder.keySet()) {
            pancakesWithAmounts += String.format("%s %s ", pancakeOrder.get(pancake), pancake);
        }
        pancakesWithAmounts = pancakesWithAmounts.trim();
        writeResponseHtml(response.getWriter(), pancakesWithAmounts);
        request.setAttribute("eMailAddress", request.getParameter("e_mail_address"));
        request.setAttribute("pancakesWithAmounts", pancakesWithAmounts);
    }

    private void writeResponseHtml(PrintWriter out, String pancakesWithAmounts) {
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Received Pancake Order</h1>");
        out.println("Thank you for ordering pancakes. Your order was:<br />");
        out.println(pancakesWithAmounts + "<br />");
        out.println("<a href='?action=invalidateSession'>Invalidate my session</a>");
        out.println("</body>");
        out.println("</html>");
    }

    private Map<Pancake, String> createPancakeOrder(HttpServletRequest request) {
        Map<Pancake, String> orderedPancakes = new HashMap<Pancake, String>();
        for (Pancake pancake : (List<Pancake>) request.getAttribute("orderablePancakeList")) {
            String pancakeAmount = request.getParameter(pancake.toString());
            if (pancakeAmount != "") {
                orderedPancakes.put(pancake, pancakeAmount);
            }
        }
        return orderedPancakes;
    }

}
