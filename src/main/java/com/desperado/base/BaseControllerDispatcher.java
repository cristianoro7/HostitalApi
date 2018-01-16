package desperado.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by desperado on 18-1-13.
 */

public abstract class BaseControllerDispatcher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchToDestination(req, resp, parseDestination(req.getServletPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchToDestination(req, resp, parseDestination(req.getServletPath()));
    }

    public abstract String parseDestination(String url);

    public void dispatchToDestination(HttpServletRequest request, HttpServletResponse response,
                                      String destination) throws ServletException, IOException {
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
