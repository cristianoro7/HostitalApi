package desperado.base;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import desperado.common.domain.Result;
import desperado.common.helper.GsonHelper;

/**
 * Created by desperado on 18-1-12.
 */

public abstract class BaseAction extends HttpServlet {

    protected void printError(HttpServletResponse response, int code, String reason) throws IOException {
        response.getWriter().println(GsonHelper.toJson(Result.buildResult(code, reason, false)));
    }

    protected <T extends Result> void printSuccess(HttpServletResponse response, T t) throws IOException {
        response.getWriter().println(GsonHelper.toJson(t));
    }

}
