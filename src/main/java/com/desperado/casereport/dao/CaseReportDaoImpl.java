package desperado.casereport.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.base.AbstractDao;
import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-14.
 */

public class CaseReportDaoImpl extends AbstractDao implements CaseReportDao {

    private static final String SQL_ADD_REPORT = "INSERT INTO case_report(patient_id, description, create_time) " +
            "VALUES(?, ?, ?);";

    private static final String SQL_QUERY_LAST_INSERT_ID = "SELECT LAST_INSERT_ID();";

    private static final String SQL_ADD_MEDICINES = "INSERT INTO medicine_list(medicine_id, case_report_id, mount, " +
            "create_time) " +
            "VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE_REPORT = "UPDATE case_report " +
            "SET is_pay = ? " +
            "WHERE case_report_id = ?";

    private static final String SQL_FINISH_APPOINTMENT = "UPDATE appointment " +
            "SET finish = ? " +
            "WHERE appointment_id = ?";

    @Override
    public int addCaseReport(CaseReportResult.CaseReport caseReport) {
        final int[] id = new int[1];
        id[0] = -1;
        int c = insert(SQL_ADD_REPORT, new Object[]{caseReport.getPatientId(), caseReport.getDescription(),
                new Timestamp(System.currentTimeMillis())});
        if (c > 0) {
            query(SQL_QUERY_LAST_INSERT_ID, null, resultSet -> id[0] = resultSet.getInt(1));
        }
        return id[0];
    }

    @Override
    public int[] addMedicineList(List<CaseReportResult.MedicineList> list, int reportId) {
        List<Object[]> args = parseListToArgs(list, reportId);
        return insertBatch(SQL_ADD_MEDICINES, args);
    }

    @Override
    public int updateCaseReport(int id, int isPay) {
        return update(SQL_UPDATE_REPORT, new Object[]{isPay, id});
    }

    @Override
    public int finishAppointment(int id, int isFinish) {
        return update(SQL_FINISH_APPOINTMENT, new Object[]{isFinish, id});
    }

    private List<Object[]> parseListToArgs(List<CaseReportResult.MedicineList> list, int reportId) {
        List<Object[]> objects = new ArrayList<>();
        for (CaseReportResult.MedicineList aList : list) {
            Object[] args = new Object[4];
            args[0] = aList.getId();
            args[1] = reportId;
            args[2] = aList.getCounts();
            args[3] = new Timestamp(System.currentTimeMillis());
            objects.add(args);
        }
        return objects;
    }
}
