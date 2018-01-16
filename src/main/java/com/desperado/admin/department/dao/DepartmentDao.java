package desperado.admin.department.dao;

import java.util.List;

import desperado.admin.department.domain.DepartmentResult;

/**
 * Created by desperado on 18-1-13.
 */

public interface DepartmentDao {

    int addDepartment(DepartmentResult.Department department);

    int updateDepartment(DepartmentResult.Department department);

    int deleteDepartment(int id);

    List<DepartmentResult.Department> listDepartments();

    DepartmentResult.Department getDepartmentById(int id);
}
