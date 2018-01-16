package desperado.pay.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;
import desperado.pay.domain.PayResult;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/pay.result")
public class PayAction extends BaseAction {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PayResult result = (PayResult) req.getAttribute("payResult");
        if (result.isSuccess()) {
            printSuccess(resp, result);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
