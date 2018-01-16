package desperado.appointment.service;

import java.util.List;

import desperado.appointment.dao.AppointmentDao;
import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.DoctorResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-14.
 */

public class AppointmentService implements Service {

    private AppointmentDao appointmentDao;

    public AppointmentService(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public AppointmentResult addAppointment(AppointmentResult.Appointment appointment) {
        AppointmentResult result = new AppointmentResult();
        int id = appointmentDao.isPatientExist(appointment.getPatient().getIdCard());
        if (id <= 0) { //不存在病人的话, 先添加病人信息
            System.out.println("病人不存在, 开始添加病人");
            int c = appointmentDao.addPatient(appointment.getPatient());
            if (c > 0) {
                System.out.println("添加成功!");
                id = appointmentDao.isPatientExist(appointment.getPatient().getIdCard());
            }
        }
        appointment.getPatient().setId(String.valueOf(id));
        int c = appointmentDao.addAppointment(appointment);
        if (c > 0) {
            result.addAppointment(appointment);
        }
        setSuccess(result);
        return result;
    }

    public AppointmentResult getAppointmentsByDoctorId(int doctorId) {
        AppointmentResult result = new AppointmentResult();
        List<AppointmentResult.Appointment> list = appointmentDao.listAppointmentsByDoctorId(doctorId);
        if (list.size() > 0) {
            result.addAppointments(list);
        }
        setSuccess(result);
        return result;
    }

    public AppointmentResult listAppointments() {
        AppointmentResult result = new AppointmentResult();
        List<AppointmentResult.Appointment> list = appointmentDao.listAppointments();
        if (list.size() > 0) {
            result.addAppointments(list);
        }
        setSuccess(result);
        return result;
    }

    public DoctorResult listDoctorById(int departmentId, int consultingRoomId) {
        DoctorResult result = new DoctorResult();
        List<DoctorResult.Doctor> list = appointmentDao.listDoctorById(departmentId, consultingRoomId);
        if (list.size() > 0) {
            result.addDoctors(list);
        }
        setSuccess(result);
        return result;
    }

    public DoctorResult listDoctors() {
        DoctorResult result = new DoctorResult();
        List<DoctorResult.Doctor> list = appointmentDao.listDoctors();
        if (list.size() > 0) {
            result.addDoctors(list);
        }
        setSuccess(result);
        return result;
    }
}
