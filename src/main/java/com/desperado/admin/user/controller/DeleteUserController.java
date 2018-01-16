package desperado.admin.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.user.domain.UserResult;
import desperado.admin.user.service.UserService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/admin/user/delete", initParams = @WebInitParam(name = "result", value = "/admin/user.result"))
public class DeleteUserController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserResult result = new UserResult();
        UserService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_USER_SERVICE);
        if (VerifyHelper.nonNull(id) && !VerifyHelper.isEmpty(id)) {
            result = service.deleteUser(Integer.parseInt(id));
        }
        render(req, resp, "userResult", result);
    }
}
