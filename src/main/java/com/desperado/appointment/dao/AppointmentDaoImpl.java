package desperado.appointment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.DoctorResult;
import desperado.appointment.domain.PatientResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-14.
 */

public class AppointmentDaoImpl extends AbstractDao implements AppointmentDao {

    private static final String SQL_IS_PATIENT_EXIST = "SELECT patient_id " +
            "FROM patient " +
            "WHERE id_card = ?;";

    private static final String SQL_ADD_PATIENT = "INSERT INTO patient(patient_name, id_card, sex, age, tel," +
            "create_time) " +
            "VALUES(?, ?, ?, ?, ?, ?);";

    private static final String SQL_ADD_APPOINTMENT = "INSERT INTO appointment(patient_id, consulting_date," +
            "doctor_id, department_id, consulting_room_id, create_time) " +
            "VALUES(?, ?, ?, ?, ?, ?);";

    private static final String SQL_QUERY_APPOINTMENTS_BY_DOCTOR_ID = "SELECT appointment_id, patient_id, patient_name, sex, age," +
            "consulting_date, doctor_name, department_name, location " +
            "FROM v_appointment " +
            "WHERE doctor_id = ? AND finish = 0;";

    private static final String SQL_QUERY_APPOINTMENTS = "SELECT appointment_id, patient_id, patient_name, sex, age," +
            "consulting_date, doctor_name, department_name, location " +
            "FROM v_appointment;";

    private static final String SQL_QUERY_DOCTOR_BY_ID = "SELECT user_id, user_name " +
            "FROM v_doctor " +
            "WHERE department_id = ? AND consulting_room_id = ?";

    private static final String SQL_QUERY_DOCTORS = "SELECT user_id, user_name " +
            "FROM v_doctor";

    @Override
    public int isPatientExist(String idCard) {
        final int[] id = {-1};
        query(SQL_IS_PATIENT_EXIST, new Object[]{idCard}, resultSet -> {
            id[0] = resultSet.getInt(1);
        });
        return id[0];
    }

    @Override
    public int addPatient(PatientResult.Patient patient) {
        return insert(SQL_ADD_PATIENT, new Object[]{patient.getName(), patient.getIdCard(), patient.getSex(),
                Integer.parseInt(patient.getAge()), patient.getTel(), new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public int addAppointment(AppointmentResult.Appointment appointment) {
        return insert(SQL_ADD_APPOINTMENT, new Object[]{Integer.parseInt(appointment.getPatient().getId()),
                appointment.getConsultingDate(), Integer.parseInt(appointment.getDoctorId()),
                Integer.parseInt(appointment.getDepartmentId()), Integer.parseInt(appointment.getConsultingRoomId()),
                new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public List<AppointmentResult.Appointment> listAppointmentsByDoctorId(int doctorId) {
        List<AppointmentResult.Appointment> list = new ArrayList<>();
        query(SQL_QUERY_APPOINTMENTS_BY_DOCTOR_ID, new Object[]{doctorId}, resultSet -> setResult(list, resultSet));
        return list;
    }

    @Override
    public List<AppointmentResult.Appointment> listAppointments() {
        List<AppointmentResult.Appointment> list = new ArrayList<>();
        query(SQL_QUERY_APPOINTMENTS, null, resultSet -> setResult(list, resultSet));
        return list;
    }

    @Override
    public List<DoctorResult.Doctor> listDoctorById(int departmentId, int consultRoomId) {
        List<DoctorResult.Doctor> list = new ArrayList<>();
        query(SQL_QUERY_DOCTOR_BY_ID, new Object[]{departmentId, consultRoomId}, resultSet -> {
            DoctorResult.Doctor doctor = new DoctorResult.Doctor();
            doctor.setId(String.valueOf(resultSet.getInt(1)));
            doctor.setName(resultSet.getString(2));
            list.add(doctor);
        });
        return list;
    }

    @Override
    public List<DoctorResult.Doctor> listDoctors() {
        List<DoctorResult.Doctor> list = new ArrayList<>();
        query(SQL_QUERY_DOCTORS, null, resultSet -> {
            DoctorResult.Doctor doctor = new DoctorResult.Doctor();
            doctor.setId(String.valueOf(resultSet.getInt(1)));
            doctor.setName(resultSet.getString(2));
            list.add(doctor);
        });
        return list;
    }

    private void setResult(List<AppointmentResult.Appointment> list, ResultSet resultSet) throws SQLException {
        AppointmentResult.Appointment appointment = new AppointmentResult.Appointment();
        appointment.setId(String.valueOf(resultSet.getInt(1)));
        appointment.getPatient().setId(String.valueOf(resultSet.getInt(2)));
        appointment.getPatient().setName(resultSet.getString(3));
        appointment.getPatient().setSex(resultSet.getString(4));
        appointment.getPatient().setAge(String.valueOf(resultSet.getInt(5)));
        appointment.setConsultingDate(resultSet.getString(6));
        appointment.setDoctorName(resultSet.getString(7));
        appointment.setDepartment(resultSet.getString(8));
        appointment.setLocation(resultSet.getString(9));
        list.add(appointment);
    }


}
