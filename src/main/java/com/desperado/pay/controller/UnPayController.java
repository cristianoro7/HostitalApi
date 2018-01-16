package desperado.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.pay.domain.UnPayResult;
import desperado.pay.service.PayService;
import desperado.pickmedicine.service.PickMedicineService;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/medicine/unpay", initParams = @WebInitParam(name = "result", value = "/unpay.result"))
public class UnPayController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PayService service = ServiceContainer.getInstance().getService(ServiceNameContract.PAY_SERVICE);
        PickMedicineService pickMedicineService = ServiceContainer.getInstance().getService(ServiceNameContract.PICK_MEDICINE_SERVICE);

        UnPayResult unPayResult = service.listUnPay(pickMedicineService);
        render(req, resp, "unPayResult", unPayResult);
    }
}
