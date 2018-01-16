package desperado.appointment.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-14.
 */

public class AppointmentResult extends Result {

    private List<Appointment> list = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            list.add(appointment);
        }
    }

    public void addAppointments(List<Appointment> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<Appointment> appointments() {
        return list;
    }

    public static class Appointment {

        private String id;

//        private String patientId;

        private String consultingDate;

        private String medicineListId;

        private String doctorId;

        private String departmentId;

        private String consultingRoomId;

        private PatientResult.Patient patient;

        private String doctorName;

        private String department;

        private String location;

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public Appointment(String id, String consultingDate, String medicineListId,
                           String doctorId, String departmentId, String consultingRoomId) {
            this.id = id;
//            this.patientId = patientId;
            this.consultingDate = consultingDate;
            this.medicineListId = medicineListId;
            this.doctorId = doctorId;
            this.departmentId = departmentId;
            this.consultingRoomId = consultingRoomId;
        }

        public Appointment(PatientResult.Patient patient, String consultingDate, String doctorId, String departmentId, String consultingRoomId) {
            this.consultingDate = consultingDate;
            this.doctorId = doctorId;
            this.departmentId = departmentId;
            this.consultingRoomId = consultingRoomId;
            this.patient = patient;
        }

        public Appointment() {

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
//
//        public String getPatientId() {
//            return patientId;
//        }

//        public void setPatientId(String patientId) {
//            this.patientId = patientId;
//        }

        public String getConsultingDate() {
            return consultingDate;
        }

        public void setConsultingDate(String consultingDate) {
            this.consultingDate = consultingDate;
        }

        public String getMedicineListId() {
            return medicineListId;
        }

        public void setMedicineListId(String medicineListId) {
            this.medicineListId = medicineListId;
        }

        public String getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(String doctorId) {
            this.doctorId = doctorId;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getConsultingRoomId() {
            return consultingRoomId;
        }

        public void setConsultingRoomId(String consultingRoomId) {
            this.consultingRoomId = consultingRoomId;
        }

        public void setPatient(PatientResult.Patient patient) {
            this.patient = patient;
        }

        public PatientResult.Patient getPatient() {
            if (patient == null) {
                patient = new PatientResult.Patient();
            }
            return patient;
        }
    }
}
