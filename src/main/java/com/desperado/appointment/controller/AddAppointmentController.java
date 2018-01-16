package desperado.appointment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.PatientResult;
import desperado.appointment.service.AppointmentService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/appointment/add", initParams = @WebInitParam(name = "result", value = "/appointment.result"))
public class AddAppointmentController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppointmentResult.Appointment appointment = parseToAppointment(parseToPatient(req), req);

        AppointmentResult result = new AppointmentResult();
        AppointmentService service = ServiceContainer.getInstance().getService(ServiceNameContract.APPOINTMENT_SERVICE);
        if (VerifyHelper.verifiedAddAppointment(appointment)) {
            result = service.addAppointment(appointment);
        }
        render(req, resp, "appointmentResult", result);
    }

    private PatientResult.Patient parseToPatient(HttpServletRequest request) {
        String name = request.getParameter("name");
        String idCard = request.getParameter("idCard");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String telPhone = request.getParameter("tel");
        return new PatientResult.Patient(name, idCard, sex, age, telPhone);
    }

    private AppointmentResult.Appointment parseToAppointment(PatientResult.Patient patient,
                                                             HttpServletRequest request) {
        String consultingDate = request.getParameter("consultingDate");
        String doctorId = request.getParameter("doctorId");
        String departmentId = request.getParameter("departmentId");
        String consultingRoomId = request.getParameter("consultingRoomId");
        return new AppointmentResult.Appointment(patient, consultingDate, doctorId, departmentId, consultingRoomId);
    }
}
