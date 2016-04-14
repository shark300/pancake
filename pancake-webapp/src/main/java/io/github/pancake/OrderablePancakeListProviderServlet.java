package io.github.pancake;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.pancake.facade.PancakeFacade;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.configuration.PancakeServiceConfiguration;

/**
 * Servlet implementation class OrderablePancakeListProviderServlet
 */
@WebServlet("/OrderablePancakeListProviderServlet")
public class OrderablePancakeListProviderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnotationConfigApplicationContext context;
    private PancakeFacade pancakeFacade;

    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(PancakeServiceConfiguration.class);
        setPancakeFacade(context.getBean(PancakeFacade.class));
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setOrderablePancakeListIntoRequest(request);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setOrderablePancakeListIntoRequest(request);
    }

    void setPancakeFacade(PancakeFacade pancakeFacade) {
        this.pancakeFacade = pancakeFacade;
    }

    private void setOrderablePancakeListIntoRequest(HttpServletRequest request) {
        request.setAttribute("orderablePancakeList", getOrderablePancakes());
    }

    private List<Pancake> getOrderablePancakes() {
        return pancakeFacade.getOrderablePancakes();
    }
}
