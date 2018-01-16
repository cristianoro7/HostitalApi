package desperado.appointment.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-14.
 */

public class PatientResult extends Result {

    private List<Patient> list = new ArrayList<>();

    public void addPatient(Patient patient) {
        if (patient != null) {
            list.add(patient);
        }
    }

    public void addPatients(List<Patient> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<Patient> patients() {
        return list;
    }

    public static class Patient {

        private String id;

        private String name;

        private String idCard;

        private String sex;

        private String age;

        private String tel;

        public Patient(String id, String name, String idCard, String sex, String age, String tel) {
            this.id = id;
            this.name = name;
            this.idCard = idCard;
            this.sex = sex;
            this.age = age;
            this.tel = tel;
        }

        public Patient(String name, String idCard, String sex, String age, String tel) {
            this.name = name;
            this.idCard = idCard;
            this.sex = sex;
            this.age = age;
            this.tel = tel;
        }

        public Patient() {

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

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
