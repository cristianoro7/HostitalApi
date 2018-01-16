package desperado.admin.title.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.title.domain.TitleResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/title.result")
public class TitleAction extends BaseAction {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TitleResult titleResult = (TitleResult) request.getAttribute("titleResult");
        if (titleResult.isSuccess()) {
            printSuccess(response, titleResult);
        } else {
            printError(response, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
