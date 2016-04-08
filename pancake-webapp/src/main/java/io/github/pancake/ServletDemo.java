package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.pancake.facade.PancakeFacade;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.configuration.PancakeServiceConfiguration;

/**
 * Demo servlet serving static content.
 *
 * @author Bence Kornis
 * @author Adorjan Nagy
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnotationConfigApplicationContext context;
    private PancakeFacade pancakeFacade;

    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(PancakeServiceConfiguration.class);
        setPancakeFacade(context.getBean(PancakeFacade.class));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Pancake> pancakes = getOrderablePancakes();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Pancake</h1>");
        for (Pancake pancake : pancakes) {
            out.println("<p>" + pancake + "</p>");
        }
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
