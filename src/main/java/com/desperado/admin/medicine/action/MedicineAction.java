package desperado.admin.medicine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.medicine.domain.MedicineResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/medicine.result")
public class MedicineAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MedicineResult medicineResult = (MedicineResult) request.getAttribute("medicineResult");
        if (medicineResult.isSuccess()) {
            printSuccess(response, medicineResult);
        } else {
            printError(response, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
