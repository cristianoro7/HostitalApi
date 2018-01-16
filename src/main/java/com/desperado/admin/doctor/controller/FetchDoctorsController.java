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
@WebServlet(urlPatterns = {"/admin/doctors", "/admin/doctor"}, initParams = @WebInitParam(name = "result", value = "/admin/doctor.result"))
public class FetchDoctorsController extends HttpServlet {

    private String URL_RESULT;

    @Override
    public void init() throws ServletException {
        URL_RESULT = getInitParameter("result");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DoctorService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_DOCTOR_SERVICE);
        DoctorResult doctorResult;

        if (id != null) {
            doctorResult = service.fetchDoctorById(id);
        } else {
            doctorResult = service.fetchDoctors();
        }
        req.setAttribute("doctorResult", doctorResult);
        req.getRequestDispatcher(URL_RESULT).forward(req, resp);
    }
}
