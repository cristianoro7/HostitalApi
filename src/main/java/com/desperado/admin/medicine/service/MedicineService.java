package desperado.admin.medicine.service;

import java.util.List;

import desperado.admin.medicine.dao.MedicineDao;
import desperado.admin.medicine.domain.MedicineResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-13.
 */

public class MedicineService implements Service {

    private MedicineDao medicineDao;

    public MedicineService(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    public void addMedicine(MedicineResult medicine) {
        int c = medicineDao.addMedicine(medicine.medicines().get(0));
        if (c > 0) {
            setSuccess(medicine);
        }
    }

    public MedicineResult deleteMedicine(String id) {
        MedicineResult result = new MedicineResult();

        int iId = Integer.parseInt(id);
        MedicineResult.Medicine medicine = medicineDao.getMedicineById(iId);
        if (medicine.getName() != null) {
            int c = medicineDao.deleteMedicine(iId);
            if (c > 0) {
                result.addMedicine(medicine);
            }
        }
        setSuccess(result);
        return result;
    }

    public MedicineResult updateMedicine(MedicineResult.Medicine medicine) {
        MedicineResult result = new MedicineResult();
        int c = medicineDao.updateMedicine(medicine);
        if (c > 0) {
            result.addMedicine(medicine);
        }
        setSuccess(result);
        return result;
    }

    public MedicineResult listMedicine() {
        MedicineResult result = new MedicineResult();
        List<MedicineResult.Medicine> list = medicineDao.listMedicine();
        if (list.size() > 0) {
            result.addMedicines(list);
        }
        setSuccess(result);
        return result;
    }

    public MedicineResult getMedicineById(int id) {
        MedicineResult result = new MedicineResult();
        MedicineResult.Medicine medicine = medicineDao.getMedicineById(id);
        if (medicine.getName() != null) {
            result.addMedicine(medicine);
        }
        setSuccess(result);
        return result;
    }
}
