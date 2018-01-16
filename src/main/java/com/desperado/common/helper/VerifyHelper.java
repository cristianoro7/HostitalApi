package desperado.common.helper;

import java.util.Objects;

import desperado.admin.consultingroom.domain.ConsultingRoomResult;
import desperado.admin.department.domain.DepartmentResult;
import desperado.admin.doctor.domain.DoctorResult;
import desperado.admin.medicine.domain.MedicineResult;
import desperado.admin.title.domain.TitleResult;
import desperado.admin.user.domain.UserResult;
import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.PatientResult;
import desperado.casereport.domain.CaseReportResult;

/**
 * Created by desperado on 18-1-12.
 */

public final class VerifyHelper {

    public static boolean verifiedLogin(String account, String password) {
        return nonNull(account) && nonNull(password) &&
                !isEmpty(account) && !isEmpty(password);
    }

    public static boolean verifiedAddDoctor(DoctorResult.Doctor doctor) {
        return nonNull(doctor.getName()) && nonNull(doctor.getSex()) && nonNull(doctor.getTel())
                && doctor.getAge() < 150 && doctor.getAge() > 18 && !isEmpty(doctor.getName())
                && !isEmpty(doctor.getSex()) && !isEmpty(doctor.getTel());
    }

    public static boolean verifiedAddTitle(TitleResult.Title title) {
        return nonNull(title.getName()) && !isEmpty(title.getName());
    }

    public static boolean verifiedUpdateTitle(TitleResult.Title title) {
        return nonNull(title.getName()) && nonNull(title.getId()) && !isEmpty(title.getId()) && !isEmpty(title.getName());
    }

    public static boolean verifiedAddMedicine(MedicineResult.Medicine medicine) {
        return nonNull(medicine.getName()) && nonNull(medicine.getPrice())
                && !isEmpty(medicine.getPrice()) && !isEmpty(medicine.getName());
    }

    public static boolean verifiedUpdateMedicine(MedicineResult.Medicine medicine) {
        return nonNull(medicine.getId()) && nonNull(medicine.getName()) && nonNull(medicine.getPrice())
                && !isEmpty(medicine.getId()) && !isEmpty(medicine.getName()) && !isEmpty(medicine.getPrice());
    }

    public static boolean verifiedAddDepartment(DepartmentResult.Department department) {
        return nonNull(department.getName()) && nonNull(department.getCounts())
                && !isEmpty(department.getName()) && !isEmpty(department.getCounts());
    }

    public static boolean verifiedUpdateDepartment(DepartmentResult.Department department) {
        return nonNull(department.getId()) && nonNull(department.getName()) && nonNull(department.getCounts())
                && !isEmpty(department.getId()) && !isEmpty(department.getName()) && !isEmpty(department.getCounts());
    }

    public static boolean verifiedUpdateRoom(ConsultingRoomResult.ConsultingRoom room) {
        return nonNull(room.getId()) && nonNull(room.getLocation()) && !isEmpty(room.getId())
                && !isEmpty(room.getLocation()) && nonNull(room.getDepartmentId()) && !isEmpty(room.getDepartmentId());
    }

    public static boolean verifiedAddUser(UserResult.User user) {
        return nonNull(user.getName()) && nonNull(user.getSex())
                && user.getAge() > 18 && user.getAge() < 150 && nonNull(user.getTel())
                && nonNull(user.getTitleId()) && nonNull(user.getAccount()) && nonNull(user.getPassword())
                && !isEmpty(user.getName()) && !isEmpty(user.getSex())
                && !isEmpty(user.getTel()) && !isEmpty(user.getTel()) && !isEmpty(user.getAccount())
                && !isEmpty(user.getPassword()) && nonNull(user.getDepartmentId())
                && !isEmpty(user.getDepartmentId()) && nonNull(user.getConsultingRoomId()) &&
                !isEmpty(user.getConsultingRoomId());
    }

    public static boolean verifiedUpdateUser(UserResult.User user) {
        return nonNull(user.getId()) && nonNull(user.getName()) && nonNull(user.getSex())
                && user.getAge() > 18 && user.getAge() < 150 && nonNull(user.getTel())
                && nonNull(user.getTitleId()) && !isEmpty(user.getId())
                && !isEmpty(user.getName()) && !isEmpty(user.getSex())
                && !isEmpty(user.getTel()) && !isEmpty(user.getTel());
    }

    public static boolean verifiedAddAppointment(AppointmentResult.Appointment appointment) {
        return verifiedPatient(appointment.getPatient()) && nonNull(appointment.getConsultingDate())
                && nonNull(appointment.getConsultingRoomId()) && nonNull(appointment.getDepartmentId())
                && nonNull(appointment.getDoctorId()) && !isEmpty(appointment.getConsultingDate())
                && !isEmpty(appointment.getConsultingRoomId()) && !isEmpty(appointment.getDepartmentId())
                && !isEmpty(appointment.getDoctorId());
    }

    public static boolean verifiedPatient(PatientResult.Patient patient) {
        return nonNull(patient.getAge()) && nonNull(patient.getIdCard())
                && nonNull(patient.getName()) && nonNull(patient.getSex())
                && !isEmpty(patient.getAge()) && !isEmpty(patient.getIdCard())
                && !isEmpty(patient.getName()) && !isEmpty(patient.getSex());
    }

    public static boolean verifiedAddCaseReport(CaseReportResult.CaseReport report, String[] ids, String[] counts) {
        return nonNull(report.getPatientId()) && nonNull(report.getDescription()) && !isEmpty(report.getPatientId())
                && !isEmpty(report.getDescription()) && ids.length == counts.length;
    }

    public static boolean nonNull(Object object) {
        return Objects.nonNull(object);
    }

    public static boolean isEmpty(String s) {
        return isEqual("", s);
    }

    public static boolean isEqual(String first, String second) {
        return first.equals(second);
    }
}
