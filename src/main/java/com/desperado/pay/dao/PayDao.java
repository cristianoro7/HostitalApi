package desperado.pay.dao;

import java.util.List;

import desperado.casereport.domain.CaseReportResult;
import desperado.pay.domain.UnPayResult;

/**
 * Created by desperado on 18-1-15.
 */

public interface PayDao {

    String getPay(List<CaseReportResult.MedicineList> list);

    int finishPay(int reportId);

    List<UnPayResult.UnPay> getUnPay();

    int addPay(int reportId);

}
