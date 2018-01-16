package desperado.appointment.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-15.
 */

public class DoctorResult extends Result {

    private List<Doctor> list = new ArrayList<>();

    public void addDoctors(List<Doctor> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<Doctor> doctors() {
        return list;
    }

    public static class Doctor {

        private String id;

        private String name;

        public Doctor(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Doctor() {

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
    }
}
