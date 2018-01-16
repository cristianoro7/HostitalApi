package desperado.casereport.service;

import desperado.base.Service;
import desperado.casereport.dao.CaseReportDao;
import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-14.
 */

public class CaseReportService implements Service {

    private CaseReportDao caseReportDao;

    public CaseReportService(CaseReportDao caseReportDao) {
        this.caseReportDao = caseReportDao;
    }

    public CaseReportResult addCaseReport(CaseReportResult.CaseReport caseReport) {
        CaseReportResult reportResult = new CaseReportResult();
        int reportId = caseReportDao.addCaseReport(caseReport);
        if (reportId > 0) { //添加成功, 开始插入药品
            caseReport.setCaseReportId(String.valueOf(reportId));
            int[] cs = caseReportDao.addMedicineList(caseReport.medicineLists(), reportId);
            if (cs.length > 0) {
                System.out.println("添加药单成功!");
                caseReportDao.finishAppointment(Integer.parseInt(caseReport.getAppointmentId()), 1);
                reportResult.addReport(caseReport);
            }
        }
        setSuccess(reportResult);
        return reportResult;
    }

    public CaseReportResult updateCaseReport(int id, int isPay) {
        CaseReportResult reportResult = new CaseReportResult();
        int c = caseReportDao.updateCaseReport(id, isPay);
        if (c > 0) {
            setSuccess(reportResult);
        }
        return reportResult;
    }
}
