package io.github.pancake;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A servlet which acts as a controller.
 *
 * @author Bence Kornis
 * @author Adorjan Nagy
 */
public class OrderControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(OrderControllerServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = getSession(request);
        if (session.getAttribute("eMailAddress") != null) {
            request.getRequestDispatcher("OrderConfirmationServlet").include(request, response);
        } else {
            request.getRequestDispatcher("OrderFormServlet").include(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("OrderConfirmationServlet").include(request, response);
        final HttpSession session = request.getSession();
        session.setAttribute("eMailAddress", request.getParameter("eMailAddress"));
        session.setAttribute("pancakesWithAmounts", request.getAttribute("pancakesWithAmounts"));
        logger.info(request.getParameter("eMailAddress") + " ordered " + request.getAttribute("pancakesWithAmounts"));
    }

    private HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if ("invalidateSession".equals(request.getParameter("action"))) {
            session.invalidate();
            session = request.getSession();
        }
        return session;
    }
    
    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
