package desperado.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.casereport.domain.CaseReportResult;
import desperado.common.helper.VerifyHelper;
import desperado.pay.domain.PayResult;
import desperado.pay.service.PayService;
import desperado.pickmedicine.service.PickMedicineService;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/medicine/pay", initParams = @WebInitParam(name = "result", value = "/pay.result"))
public class PayController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("reportId");
        System.out.println("reportId:" + id);

        PayResult result = new PayResult();
        PayService service = ServiceContainer.getInstance().getService(ServiceNameContract.PAY_SERVICE);
        PickMedicineService pickMedicineService = ServiceContainer.getInstance().getService(ServiceNameContract.PICK_MEDICINE_SERVICE);
        if (VerifyHelper.nonNull(id) && !VerifyHelper.isEmpty(id)) {
            List<CaseReportResult.MedicineList> lists = pickMedicineService.getMedicineListById(Integer.parseInt(id))
                    .getList()
                    .getMedicineLists();
            result = service.getPay(lists, Integer.parseInt(id));
        }
        render(req, resp, "payResult", result);
    }
}
