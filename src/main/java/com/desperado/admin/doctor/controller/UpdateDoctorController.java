package desperado.admin.doctor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.doctor.domain.DoctorResult;
import desperado.admin.doctor.service.DoctorService;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/doctor/update", initParams = @WebInitParam(name = "result", value = "/admin/doctor.result"))
public class UpdateDoctorController extends HttpServlet {

    private String URL_RESULT;

    @Override
    public void init() throws ServletException {
        URL_RESULT = getInitParameter("result");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        String tel = req.getParameter("tel");
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        int consultingRoomId = Integer.parseInt(req.getParameter("consultingRoomId"));
        DoctorResult.Doctor doctor = new DoctorResult.Doctor(name, sex, age, tel,
                departmentId, consultingRoomId);
        doctor.setId(id);

        DoctorService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_DOCTOR_SERVICE);
        DoctorResult doctorResult = new DoctorResult();
        doctorResult.addDoctor(doctor);
        service.updateDoctor(doctorResult);

        req.setAttribute("doctorResult", doctorResult);
        req.getRequestDispatcher(URL_RESULT).forward(req, resp);
    }
}
