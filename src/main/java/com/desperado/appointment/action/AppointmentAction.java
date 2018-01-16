package desperado.appointment.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.appointment.domain.AppointmentResult;
import desperado.appointment.domain.DoctorResult;
import desperado.base.BaseAction;
import desperado.common.domain.Result;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/appointment.result")
public class AppointmentAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Result result = (Result) request.getAttribute("appointmentResult");
        if (result.isSuccess()) {
            if (result instanceof AppointmentResult) {
                AppointmentResult r = (AppointmentResult) result;
                printSuccess(response, r);
            } else {
                DoctorResult r = (DoctorResult) result;
                printSuccess(response, r);
            }

        } else {
            printError(response, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
