package desperado.admin.department.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.department.domain.DepartmentResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/department.result")
public class DepartmentAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DepartmentResult departmentResult = (DepartmentResult) req.getAttribute("departmentResult");
        if (departmentResult.isSuccess()) {
            printSuccess(resp, departmentResult);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
