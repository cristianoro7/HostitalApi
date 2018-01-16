package desperado.casereport.controller;

import java.io.IOException;

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
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/casereport/update", initParams = @WebInitParam(name = "result", value = "/casereport.result"))
public class UpdateCaseReportController extends BaseController {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int isPay = parsePay(req);

        CaseReportResult reportResult = new CaseReportResult();
        CaseReportService service = ServiceContainer.getInstance().getService(ServiceNameContract.CASE_REPORT_SERVICE);
        if (VerifyHelper.nonNull(id) && !VerifyHelper.isEmpty(id)) {
            reportResult = service.updateCaseReport(Integer.parseInt(id), isPay);
        }
        render(req, resp, "reportResult", reportResult);
    }

    private int parsePay(HttpServletRequest request) {
        String isPay = request.getParameter("isPay");
        return isPay.equals("1") ? 1 : 0;
    }
}
