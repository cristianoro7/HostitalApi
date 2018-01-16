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
@WebServlet(urlPatterns = "/admin/user/update", initParams = @WebInitParam(name = "result", value = "/admin/user.result"))
public class UpdateController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String tel = req.getParameter("tel");
        String titleId = req.getParameter("titleId");
        String departmentId = req.getParameter("departmentId");
        String consultingRoomId = req.getParameter("consultingRoomId");

        System.out.println("id: " + id + ", name: " + name + ", sex: " + sex + ", age: " + age + ", tel: " + tel
                + "titleId: " + titleId + ", dId: " + departmentId + ", cId: " + consultingRoomId);
        UserResult.User user = new UserResult.User(id, name, sex, Integer.parseInt(age), tel, titleId, departmentId, consultingRoomId);

        UserResult result = new UserResult();
        UserService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_USER_SERVICE);
        if (VerifyHelper.verifiedUpdateUser(user)) {
            result = service.updateUser(user);
        }
        render(req, resp, "userResult", result);
    }
}
