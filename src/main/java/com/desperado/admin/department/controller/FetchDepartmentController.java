package desperado.admin.department.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.department.domain.DepartmentResult;
import desperado.admin.department.service.DepartmentService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = {"/admin/departments", "/admin/department"},
        initParams = @WebInitParam(name = "result", value = "/admin/department.result"))
public class FetchDepartmentController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        DepartmentResult result;
        DepartmentService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_DEPARTMENT_SERVICE);
        if (VerifyHelper.nonNull(id)) {
            result = service.getDepartmentById(Integer.parseInt(id));
        } else {
            result = service.listDepartment();
        }
        render(req, resp, "departmentResult", result);
    }
}
