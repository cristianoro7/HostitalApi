package desperado.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by desperado on 18-1-13.
 */

public abstract class BaseController extends HttpServlet {

    private String URL_RESULT;

    @Override
    public void init() throws ServletException {
        URL_RESULT = getInitParameter("result");
    }

    public <T> void render(HttpServletRequest request, HttpServletResponse response, String attrName, T t) throws ServletException, IOException {
        request.setAttribute(attrName, t);
        request.getRequestDispatcher(URL_RESULT).forward(request, response);
    }
}
