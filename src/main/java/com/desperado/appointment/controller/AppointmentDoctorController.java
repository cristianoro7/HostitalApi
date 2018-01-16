package desperado.appointment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.appointment.domain.DoctorResult;
import desperado.appointment.service.AppointmentService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;

/**
 * Created by desperado on 18-1-15.
 */
@WebServlet(urlPatterns = {"/appointment/doctor", "/appointment/doctors"},
        initParams = @WebInitParam(name = "result", value = "/appointment.result"))
public class AppointmentDoctorController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentId = req.getParameter("departmentId");
        String consultingRoom = req.getParameter("consultingRoomId");
        System.out.println("dId: " + departmentId + ", rId: " + consultingRoom);

        DoctorResult result;
        AppointmentService service = ServiceContainer.getInstance().getService(ServiceNameContract.APPOINTMENT_SERVICE);
        if (departmentId != null && consultingRoom != null) {
            result = service.listDoctorById(Integer.parseInt(departmentId), Integer.parseInt(consultingRoom));
        } else {
            result = service.listDoctors();
        }
        render(req, resp, "appointmentResult", result);
    }
}
