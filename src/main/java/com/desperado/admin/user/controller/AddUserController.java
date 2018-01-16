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
 * Created by desperado on 18-1-12.
 */
@WebServlet(urlPatterns = "/admin/user/add", initParams = @WebInitParam(name = "result", value = "/admin/user.result"))
public class AddUserController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String tel = req.getParameter("tel");
        String titleId = req.getParameter("titleId");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String departmentId = req.getParameter("departmentId");
        String consultingRoomId = req.getParameter("consultingRoomId");

        System.out.println(", name: " + name + ", sex: " + sex + ", age: " + age + ", tel: " + tel
                + "titleId: " + titleId + ", ac: " + account + ", pw: " + password + "dId: " + departmentId
                + ", cId: " + consultingRoomId);
        UserResult.User user = new UserResult.User(name, sex, (age != null ? Integer.parseInt(age) :
                0), tel, titleId, account, password,
                departmentId, consultingRoomId);

        UserResult result = new UserResult();
        UserService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_USER_SERVICE);
        if (VerifyHelper.verifiedAddUser(user)) {
            result = service.addUser(user);
        }
        render(req, resp, "userResult", result);
    }
}
