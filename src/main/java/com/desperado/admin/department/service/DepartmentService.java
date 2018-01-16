package desperado.admin.department.service;

import java.util.List;

import desperado.admin.department.dao.DepartmentDao;
import desperado.admin.department.domain.DepartmentResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-13.
 */

public class DepartmentService implements Service {

    private DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public DepartmentResult addDepartment(DepartmentResult.Department department) {
        int c = departmentDao.addDepartment(department);
        DepartmentResult result = new DepartmentResult();
        if (c > 0) {
            result.addDepartment(department);
        }
        setSuccess(result);
        return result;
    }

    public DepartmentResult updateDepartment(DepartmentResult.Department department) {
        int c = departmentDao.updateDepartment(department);
        DepartmentResult result = new DepartmentResult();
        if (c > 0) {
            result.addDepartment(department);
        }
        setSuccess(result);
        return result;
    }

    public DepartmentResult getDepartmentById(int id) {
        DepartmentResult.Department department = departmentDao.getDepartmentById(id);
        DepartmentResult result = new DepartmentResult();

        if (department.getName() != null) {
            result.addDepartment(department);
        }
        setSuccess(result);
        return result;
    }

    public DepartmentResult deleteDepartment(int id) {
        DepartmentResult.Department department = departmentDao.getDepartmentById(id);
        DepartmentResult result = new DepartmentResult();

        if (department.getName() != null) {
            int c = departmentDao.deleteDepartment(id);
            if (c > 0) {
                result.addDepartment(department);
            }
        }
        setSuccess(result);
        return result;
    }

    public DepartmentResult listDepartment() {
        DepartmentResult result = new DepartmentResult();
        List<DepartmentResult.Department> list = departmentDao.listDepartments();
        if (list.size() > 0) {
            result.addDepartments(list);
        }
        setSuccess(result);
        return result;
    }
}
