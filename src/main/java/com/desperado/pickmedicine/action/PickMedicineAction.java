package desperado.pickmedicine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;
import desperado.pickmedicine.domain.PickMedicineResult;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/pick.result")
public class PickMedicineAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PickMedicineResult result = (PickMedicineResult) req.getAttribute("pickResult");
        if (result.isSuccess()) {
            printSuccess(resp, result);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
