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
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/department/add", initParams = @WebInitParam(name = "result", value = "/admin/department.result"))
public class AddDepartmentController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String counts = req.getParameter("counts");
        DepartmentResult.Department department = new DepartmentResult.Department(name, counts);

        DepartmentResult result = new DepartmentResult();
        DepartmentService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_DEPARTMENT_SERVICE);
        if (VerifyHelper.verifiedAddDepartment(department)) {
            result = service.addDepartment(department);

        }
        render(req, resp, "departmentResult", result);
    }
}
