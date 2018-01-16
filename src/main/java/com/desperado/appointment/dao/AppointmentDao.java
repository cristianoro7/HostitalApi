package desperado.appointment.dao;

import java.util.List;

import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.DoctorResult;
import desperado.appointment.domain.PatientResult;

/**
 * Created by desperado on 18-1-14.
 */

public interface AppointmentDao {

    int isPatientExist(String idCard);

    int addPatient(PatientResult.Patient patient);

    int addAppointment(AppointmentResult.Appointment appointment);

    List<AppointmentResult.Appointment> listAppointmentsByDoctorId(int doctorId);

    List<AppointmentResult.Appointment> listAppointments();

    List<DoctorResult.Doctor> listDoctorById(int departmentId, int consultRoomId);

    List<DoctorResult.Doctor> listDoctors();

}
