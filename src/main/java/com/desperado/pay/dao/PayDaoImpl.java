package desperado.pay.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import desperado.base.AbstractDao;
import desperado.casereport.domain.CaseReportResult;
import desperado.pay.domain.UnPayResult;

/**
 * Created by desperado on 18-1-15.
 */

public class PayDaoImpl extends AbstractDao implements PayDao {

    private static final String SQL_FINISH_PAY = "UPDATE case_report " +
            "SET is_pay = ? " +
            "WHERE case_report_id = ?";

    private static final String SQL_QUERY_UNPAY = "SELECT case_report.case_report_id, case_report.patient_id," +
            "patient.patient_name " +
            "FROM case_report, patient " +
            "WHERE is_pay = 0 AND patient.patient_id = case_report.patient_id";

    private static final String SQL_ADD_PAY = "INSERT INTO pay_list(case_report_id, total_price, create_time) " +
            "VALUES(?, ?, ?)";

    @Override
    public String getPay(List<CaseReportResult.MedicineList> list) {
        double totalPrice = -1;
        for (CaseReportResult.MedicineList m : list) {
            BigDecimal bigDecimal = new BigDecimal(m.getPrice());
            totalPrice += bigDecimal.doubleValue() * Integer.parseInt(m.getCounts());
        }
        return String.valueOf(totalPrice);
    }

    @Override
    public int finishPay(int reportId) {
        return update(SQL_FINISH_PAY, new Object[]{1, reportId});
    }

    @Override
    public List<UnPayResult.UnPay> getUnPay() {
        List<UnPayResult.UnPay> unPays = new ArrayList<>();
        query(SQL_QUERY_UNPAY, null, resultSet -> {
            UnPayResult.UnPay unPay = new UnPayResult.UnPay();
            unPay.getMedicine().setReportId(String.valueOf(resultSet.getInt(1)));
            unPay.getMedicine().setPatientId(String.valueOf(resultSet.getInt(2)));
            unPay.getMedicine().setPatientName(resultSet.getString(3));
            unPays.add(unPay);
            System.out.println("rId: " + unPay.getMedicine().getReportId() + ", pId: " +
                    unPay.getMedicine().getPatientId() + ", pName: " + unPay.getMedicine().getPatientName());
        });
        return unPays;
    }

    @Override
    public int addPay(int reportId) {
        return update(SQL_ADD_PAY, new Object[]{reportId});
    }
}
