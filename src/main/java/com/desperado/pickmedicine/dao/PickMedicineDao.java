package desperado.pickmedicine.dao;

import java.util.List;

import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-15.
 */

public interface PickMedicineDao {

    List<CaseReportResult.MedicineList> getMedicineListById(int reportId);


}
