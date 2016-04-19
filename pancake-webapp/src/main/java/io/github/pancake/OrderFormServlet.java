package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.pancake.configuration.PancakeConfiguration;
import io.github.pancake.facade.PancakeFacade;
import io.github.pancake.persistence.base.Pancake;

/**
 * Pancake order form HTML provider servlet.
 * 
 * @author Adorjan Nagy
 */
@WebServlet("/OrderFormServlet")
public class OrderFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnotationConfigApplicationContext context;
    private PancakeFacade pancakeFacade;

    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(PancakeConfiguration.class);
        setPancakeFacade(context.getBean(PancakeFacade.class));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Pancake Order Form</h1>");
        out.println("<form action='" + request.getRequestURI() + "' method='POST'>");
        out.println("Your e-mail address: <input type='text' name='eMailAddress'><br />");
        for (Pancake pancake : getOrderablePancakes()) {
            out.println(String.format("%s: <input type='text' name='%s'> pieces<br />", pancake, pancake));
        }
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    void setPancakeFacade(PancakeFacade pancakeFacade) {
        this.pancakeFacade = pancakeFacade;
    }

    private List<Pancake> getOrderablePancakes() {
        return pancakeFacade.getOrderablePancakes();
    }
}
