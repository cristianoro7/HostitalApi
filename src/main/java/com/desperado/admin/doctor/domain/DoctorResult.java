package desperado.admin.doctor.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-13.
 */

public class DoctorResult extends Result {


    List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);

        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public static class Doctor{
        private String id;

        private String name;

        private String sex;

        private int age;

        private String tel;

        private int departmentId;

        private int consultingRoomId;

        public Doctor() {
        }

        public Doctor(String name, String sex, int age, String tel, int departmentId, int consultingRoomId) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.tel = tel;
            this.departmentId = departmentId;
            this.consultingRoomId = consultingRoomId;
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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getConsultingRoomId() {
            return consultingRoomId;
        }

        public void setConsultingRoomId(int consultingRoomId) {
            this.consultingRoomId = consultingRoomId;
        }
    }

}
