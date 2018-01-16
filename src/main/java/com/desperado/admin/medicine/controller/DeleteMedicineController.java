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
@WebServlet(urlPatterns = "/admin/medicine/delete", initParams = @WebInitParam(name = "result", value = "/admin/medicine.result"))
public class DeleteMedicineController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        MedicineResult result = null;
        MedicineService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_MEDICINE_SERVICE);
        if (VerifyHelper.nonNull(id) && !VerifyHelper.isEmpty(id)) {
            result = service.deleteMedicine(id);
        }
        render(req, resp, "medicineResult", result);
    }
}
