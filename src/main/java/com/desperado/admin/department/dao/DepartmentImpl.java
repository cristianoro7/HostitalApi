package desperado.admin.department.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.admin.department.domain.DepartmentResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-13.
 */

public class DepartmentImpl extends AbstractDao implements DepartmentDao {

    private static final String SQL_DELETE_DEPARTMENT = "DELETE FROM " +
            "department " +
            "WHERE department_id = ?";

    private static final String SQL_UPDATE_DEPARTMENT = "UPDATE department " +
            "SET department_name = ?, counts = ?, modified_time = ? " +
            "WHERE department_id = ?;";

    private static final String SQL_ADD_DEPARTMENT = "INSERT INTO department(department_name, counts, create_time) " +
            "VALUES(?, ?, ?);";

    private static final String SQL_QUERY_DEPARTMENT = "SELECT department_name, counts " +
            "FROM department " +
            "WHERE department_id = ?;";

    private static final String SQL_QUERY_ALL_DEPARTMENT = "SELECT department_id, department_name, counts " +
            "FROM department";

    @Override
    public int addDepartment(DepartmentResult.Department department) {
        return insert(SQL_ADD_DEPARTMENT, new Object[]{department.getName(), Integer.parseInt(department.getCounts()),
                new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public int updateDepartment(DepartmentResult.Department department) {
        return update(SQL_UPDATE_DEPARTMENT, new Object[]{department.getName(), Integer.parseInt(department.getCounts()),
                new Timestamp(System.currentTimeMillis()), Integer.parseInt(department.getId())});
    }

    @Override
    public int deleteDepartment(int id) {
        return delete(SQL_DELETE_DEPARTMENT, new Object[]{id});
    }

    @Override
    public List<DepartmentResult.Department> listDepartments() {
        List<DepartmentResult.Department> list = new ArrayList<>();
        query(SQL_QUERY_ALL_DEPARTMENT, null, resultSet -> {
            DepartmentResult.Department department = new DepartmentResult.Department();
            department.setId(String.valueOf(resultSet.getInt(1)));
            department.setName(resultSet.getString(2));
            department.setCounts(String.valueOf(resultSet.getInt(3)));
            list.add(department);
        });
        return list;
    }

    @Override
    public DepartmentResult.Department getDepartmentById(int id) {
        DepartmentResult.Department department = new DepartmentResult.Department();
        query(SQL_QUERY_DEPARTMENT, new Object[]{id}, resultSet -> {
            department.setId(String.valueOf(id));
            department.setName(resultSet.getString(1));
            department.setCounts(String.valueOf(resultSet.getInt(2)));
        });
        return department;
    }
}
