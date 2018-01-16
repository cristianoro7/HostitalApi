package desperado.pickmedicine.service;

import java.util.List;

import desperado.base.Service;
import desperado.casereport.domain.CaseReportResult;
import desperado.pickmedicine.dao.PickMedicineDao;
import desperado.pickmedicine.domain.PickMedicineResult;

/**
 * Created by desperado on 18-1-15.
 */

public class PickMedicineService implements Service {

    private PickMedicineDao pickMedicineDao;

    public PickMedicineService(PickMedicineDao pickMedicineDao) {
        this.pickMedicineDao = pickMedicineDao;
    }

    public PickMedicineResult getMedicineListById(int reportId) {
        PickMedicineResult result = new PickMedicineResult();
        List<CaseReportResult.MedicineList> lists = pickMedicineDao.getMedicineListById(reportId);
        if (lists.size() > 0) {
            PickMedicineResult.PickMedicine pickMedicine = new PickMedicineResult.PickMedicine(String.valueOf(reportId));
            pickMedicine.addMedicineList(lists);
            result.setList(pickMedicine);
        }
        setSuccess(result);
        return result;
    }


}
