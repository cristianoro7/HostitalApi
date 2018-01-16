package desperado.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import desperado.admin.user.domain.UserResult;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;
import desperado.login.service.LoginService;

/**
 * Created by desperado on 18-1-12.
 */
@WebServlet(urlPatterns = "/login", initParams = @WebInitParam(name = "result", value = "/login.result")
)
public class LoginController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        boolean isValid = VerifyHelper.verifiedLogin(account, password);
        UserResult userResult = new UserResult();
        LoginService service = ServiceContainer.getInstance().getService(ServiceNameContract.LOGIN_SERVICE);
        if (isValid) {
            userResult = service.login(account, password);
            tryAddSession(req.getSession(), userResult);
        }
        render(req, resp, "loginResult", userResult);
    }

    private void tryAddSession(HttpSession session, UserResult user) {
        if (user.isSuccess()) {
            session.setAttribute("user", user.getUsers().get(0));
        }
    }
}
