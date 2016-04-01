package io.github.pancake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.di.configuration.PancakeDIConfiguration;
import io.github.di.consumer.MyApplication;

/**
 * Demo servlet serving static content
 *
 * @author Bence Kornis
 *
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Set<String> pancakes = getPancakes();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Pancake 3</h1>");
        for (String pancake : pancakes)
            out.println("<p>" + pancake + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    private Set<String> getPancakes() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PancakeDIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);
        return app.retrievePancakes();
    }
}
