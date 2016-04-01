package io.github.pancake.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.PancakeService;

/**
 * Demo servlet serving static content
 *
 * @author Bence_Kornis
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private PancakeService pancakeService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<Pancake> pancakeTypes = listPancakeTypes();
        out.println("<html>");
        out.println("<body>");
        for (Pancake pancakeType : pancakeTypes) {
            out.println(String.format("<p>%s</p>", pancakeType.toString()));
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    private List<Pancake> listPancakeTypes() {
        return pancakeService.getAccessiblePancakeTypes();
    }
}
