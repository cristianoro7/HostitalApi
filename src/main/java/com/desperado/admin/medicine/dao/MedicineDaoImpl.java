package desperado.admin.medicine.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.admin.medicine.domain.MedicineResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-13.
 */

public class MedicineDaoImpl extends AbstractDao implements MedicineDao {

    private static final String SQL_ADD_MEDICINE = "INSERT INTO medicine(medicine_name, price, create_time) " +
            "VALUES(?, ?, ?);";

    private static final String SQL_DELETE_MEDICINE = "DELETE FROM medicine " +
            "WHERE medicine_id = ?;";

    private static final String SQL_QUERY_MEDICINE = "SELECT medicine_name, price " +
            "FROM medicine " +
            "WHERE medicine_id = ?";

    private static final String SQL_UPDATE_MEDICINE = "UPDATE medicine " +
            "SET medicine_name = ?, price = ?, modified_time = ? " +
            "WHERE medicine_id = ?";

    private static final String SQL_QUERY_ALL_MEDICINE = "SELECT medicine_id, medicine_name, price " +
            "FROM medicine;";

    @Override
    public int addMedicine(MedicineResult.Medicine medicine) {
        return insert(SQL_ADD_MEDICINE, new Object[]{medicine.getName(), new BigDecimal(medicine.getPrice()),
                new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public MedicineResult.Medicine getMedicineById(int id) {
        MedicineResult.Medicine medicine = new MedicineResult.Medicine();
        query(SQL_QUERY_MEDICINE, new Object[]{id}, resultSet -> {
            medicine.setId(String.valueOf(id));
            medicine.setName(resultSet.getString(1));
            medicine.setPrice(String.valueOf(resultSet.getBigDecimal(2)));
        });
        return medicine;
    }

    @Override
    public int deleteMedicine(int id) {
        return delete(SQL_DELETE_MEDICINE, new Object[]{id});
    }

    @Override
    public int updateMedicine(MedicineResult.Medicine medicine) {
        return update(SQL_UPDATE_MEDICINE, new Object[]{medicine.getName(), new BigDecimal(medicine.getPrice()),
                new Timestamp(System.currentTimeMillis()), Integer.parseInt(medicine.getId())});
    }

    @Override
    public List<MedicineResult.Medicine> listMedicine() {
        List<MedicineResult.Medicine> list = new ArrayList<>();
        query(SQL_QUERY_ALL_MEDICINE, null, resultSet -> {
            MedicineResult.Medicine medicine = new MedicineResult.Medicine();
            medicine.setId(String.valueOf(resultSet.getInt(1)));
            medicine.setName(resultSet.getString(2));
            medicine.setPrice(String.valueOf((resultSet.getBigDecimal(3))));
            list.add(medicine);
        });
        return list;
    }
}
