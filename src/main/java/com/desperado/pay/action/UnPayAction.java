package desperado.pay.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;
import desperado.pay.domain.UnPayResult;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/unpay.result")
public class UnPayAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UnPayResult unPayResult = (UnPayResult) req.getAttribute("unPayResult");
        if (unPayResult.isSuccess()) {
            printSuccess(resp, unPayResult);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
