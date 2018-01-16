package desperado.appointment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.service.AppointmentService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = {"/appointments", "/appointment"}, initParams = @WebInitParam(name = "result", value = "/appointment.result"))
public class FetchAppointmentController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("doctorId");

        AppointmentResult result;
        AppointmentService service = ServiceContainer.getInstance().getService(ServiceNameContract.APPOINTMENT_SERVICE);
        if (id != null) {
            result = service.getAppointmentsByDoctorId(Integer.parseInt(id));
        } else {
            result = service.listAppointments();
        }
        render(req, resp, "appointmentResult", result);
    }
}
