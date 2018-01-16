package desperado.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;
import desperado.admin.user.domain.UserResult;

/**
 * Created by desperado on 18-1-12.
 */
@WebServlet(urlPatterns = "/login.result")
public class LoginAction extends BaseAction {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserResult user = (UserResult) req.getAttribute("loginResult");
        if (user.isSuccess()) {
            printSuccess(resp, user);
        } else {
            printError(resp, ResultCodeHelper.CODE_ACCOUNT_OR_PASSWORD_ERROR, "账号/密码错误!");
        }
    }
}
