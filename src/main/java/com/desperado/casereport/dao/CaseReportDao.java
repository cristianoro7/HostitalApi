package desperado.casereport.dao;

import java.util.List;

import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-14.
 */

public interface CaseReportDao {

    /**
     * 添加病例, 返回的是添加后的ID
     * @param caseReport
     * @return 病例的ID
     */
    int addCaseReport(CaseReportResult.CaseReport caseReport);

    int[] addMedicineList(List<CaseReportResult.MedicineList> list, int reportId);

    int updateCaseReport(int id, int isPay);

    int finishAppointment(int id, int isFinish);

}
