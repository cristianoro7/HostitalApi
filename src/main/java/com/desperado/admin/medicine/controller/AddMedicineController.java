package desperado.admin.medicine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.medicine.domain.MedicineResult;
import desperado.admin.medicine.service.MedicineService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/medicine/add", initParams = @WebInitParam(name = "result", value = "/admin/medicine.result"))
public class AddMedicineController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        MedicineResult.Medicine medicine = new MedicineResult.Medicine(name, price);
        MedicineResult result = new MedicineResult(medicine);

        MedicineService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_MEDICINE_SERVICE);
        if (VerifyHelper.verifiedAddMedicine(medicine)) {
            service.addMedicine(result);
        }
        render(req, resp, "medicineResult", result);
    }
}
