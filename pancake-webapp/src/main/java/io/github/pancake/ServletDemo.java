package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.pancake.configuration.PancakeConfiguration;
import io.github.pancake.consumer.PancakeApplication;
import io.github.pancake.persistence.base.Pancake;

/**
 * Demo servlet serving static content.
 *
 * @author Bence Kornis
 * @author Adorjan Nagy
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

    @SuppressWarnings("resource")
    private List<Pancake> getOrderablePancakes() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PancakeConfiguration.class);
        PancakeApplication application = context.getBean(PancakeApplication.class);
        return application.getOrderablePancakes();
    }
}
