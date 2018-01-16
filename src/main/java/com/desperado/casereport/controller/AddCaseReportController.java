package desperado.casereport.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import desperado.casereport.service.CaseReportService;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/casereport/add", initParams = @WebInitParam(name = "result", value = "/casereport.result"))
public class AddCaseReportController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appointmentId = req.getParameter("appointmentId");
        String patientId = req.getParameter("patientId");
        String description = req.getParameter("description");
        String medicineId = req.getParameter("medicineId");
        String counts = req.getParameter("counts");

        String[] medicineIds = parseMedicineInfo(medicineId);
        String[] medicineCounts = parseMedicineInfo(counts);
        CaseReportResult.CaseReport caseReport = new CaseReportResult.CaseReport(appointmentId, patientId, description, false);

        CaseReportService service = ServiceContainer.getInstance().getService(ServiceNameContract.CASE_REPORT_SERVICE);
        CaseReportResult reportResult = new CaseReportResult();
        if (VerifyHelper.verifiedAddCaseReport(caseReport, medicineIds, medicineCounts)) {
            caseReport.addMedicines(packMedicines(medicineIds, medicineCounts));
            reportResult = service.addCaseReport(caseReport);
        }
        render(req, resp, "reportResult", reportResult);
    }

    private String[] parseMedicineInfo(String info) {
        if (info != null) {
            return info.split("&");
        }
        return new String[0];
    }

    private List<CaseReportResult.MedicineList> packMedicines(String[] ids, String[] counts) {
        if (ids != null && counts != null) {
            List<CaseReportResult.MedicineList> lists = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                CaseReportResult.MedicineList medicineList = new CaseReportResult.MedicineList();
                medicineList.setId(ids[i]);
                medicineList.setCounts(counts[i]);
                lists.add(medicineList);
            }
            return lists;
        }
        return new ArrayList<>();
    }
}
