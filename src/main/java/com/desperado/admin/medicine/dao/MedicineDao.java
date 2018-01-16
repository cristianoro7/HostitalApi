package desperado.admin.medicine.dao;

import java.util.List;

import desperado.admin.medicine.domain.MedicineResult;

/**
 * Created by desperado on 18-1-13.
 */

public interface MedicineDao {

    int addMedicine(MedicineResult.Medicine medicine);

    MedicineResult.Medicine getMedicineById(int id);

    int deleteMedicine(int id);

    int updateMedicine(MedicineResult.Medicine medicine);

    List<MedicineResult.Medicine> listMedicine();
}
