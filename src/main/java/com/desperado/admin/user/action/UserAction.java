package desperado.admin.user.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.user.domain.UserResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/admin/user.result")
public class UserAction extends BaseAction {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserResult departmentResult = (UserResult) request.getAttribute("userResult");
        if (departmentResult.isSuccess()) {
            printSuccess(response, departmentResult);
        } else {
            printError(response, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
