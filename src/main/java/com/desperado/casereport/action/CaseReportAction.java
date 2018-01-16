package desperado.casereport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.base.BaseAction;
import desperado.casereport.domain.CaseReportResult;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = "/casereport.result")
public class CaseReportAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaseReportResult caseReportResult = (CaseReportResult) request.getAttribute("reportResult");
        if (caseReportResult.isSuccess()) {
            printSuccess(response, caseReportResult);
        } else {
            printError(response, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
