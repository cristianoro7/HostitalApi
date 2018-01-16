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

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = {"/admin/users", "/admin/user"}, initParams = @WebInitParam(name = "result", value = "/admin/user.result"))
public class FetchUserController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("titleId");

        UserResult result;
        UserService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_USER_SERVICE);
        if (id != null) {
            result = service.listUserByTitle(Integer.parseInt(id));
        } else {
            result = service.listUser();
        }
        render(req, resp, "userResult", result);
    }
}
