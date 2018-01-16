package desperado.admin.department.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-13.
 */

public class DepartmentResult extends Result {

    private List<Department> list = new ArrayList<>();

    public void addDepartment(Department department) {
        if (department != null) {
            list.add(department);
        }
    }

    public void addDepartments(List<Department> departments) {
        if (departments != null) {
            list.addAll(departments);
        }
    }

    public List<Department> departments() {
        return list;
    }

    public static class Department {

        private String id;

        private String name;

        private String counts;

        public Department(String id, String name, String counts) {
            this.id = id;
            this.name = name;
            this.counts = counts;
        }

        public Department(String name, String counts) {
            this.name = name;
            this.counts = counts;
        }

        public Department() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCounts() {
            return counts;
        }

        public void setCounts(String counts) {
            this.counts = counts;
        }
    }
}
