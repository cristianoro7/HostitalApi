package desperado.pickmedicine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;
import desperado.pickmedicine.domain.PickMedicineResult;
import desperado.pickmedicine.service.PickMedicineService;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/medicine/pick", initParams = @WebInitParam(name = "result", value = "/pick.result"))
public class PickMedicineController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reportId = req.getParameter("reportId");

        PickMedicineResult pickMedicineResult = new PickMedicineResult();
        PickMedicineService service = ServiceContainer.getInstance().getService(ServiceNameContract.PICK_MEDICINE_SERVICE);
        if (VerifyHelper.nonNull(reportId) && !VerifyHelper.isEmpty(reportId)) {
            pickMedicineResult = service.getMedicineListById(Integer.parseInt(reportId));
        }
        render(req, resp, "pickResult", pickMedicineResult);
    }
}
