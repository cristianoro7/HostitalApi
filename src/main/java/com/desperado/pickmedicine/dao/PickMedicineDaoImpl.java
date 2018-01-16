package desperado.pickmedicine.dao;

import java.util.ArrayList;
import java.util.List;

import desperado.base.AbstractDao;
import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-15.
 */

public class PickMedicineDaoImpl extends AbstractDao implements PickMedicineDao {

    private static final String SQL_QUERY_BY_ID = "SELECT medicine_id, medicine_name, price, mount " +
            "FROM v_medicine_list " +
            "WHERE case_report_id = ?";

    @Override
    public List<CaseReportResult.MedicineList> getMedicineListById(int reportId) {
        List<CaseReportResult.MedicineList> lists = new ArrayList<>();
        query(SQL_QUERY_BY_ID, new Object[]{reportId}, resultSet -> {
            CaseReportResult.MedicineList list = new CaseReportResult.MedicineList();
            list.setId(String.valueOf(resultSet.getInt(1)));
            list.setName(resultSet.getString(2));
            list.setPrice(resultSet.getBigDecimal(3).toString());
            list.setCounts(String.valueOf(resultSet.getInt(4)));
            lists.add(list);
        });
        return lists;
    }
}
