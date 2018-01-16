package desperado.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.common.domain.Result;
import desperado.common.helper.GsonHelper;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-12.
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().println(GsonHelper.toJson(Result.buildResult(ResultCodeHelper.CODE_SUCCESS,
                "注销成功", true)));
    }
}
