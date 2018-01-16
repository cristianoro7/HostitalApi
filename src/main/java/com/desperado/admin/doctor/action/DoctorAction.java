package desperado.admin.doctor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.doctor.domain.DoctorResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/doctor.result")
public class DoctorAction extends BaseAction {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorResult doctor = (DoctorResult) req.getAttribute("doctorResult");
        if (doctor.isSuccess()) {
            printSuccess(resp, doctor);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorResult doctor = (DoctorResult) req.getAttribute("doctorResult");
        if (doctor.isSuccess()) {
            printSuccess(resp, doctor);
        } else {
            printError(resp, ResultCodeHelper.CODE_PARAMSTER_ERROR, "参数错误, 请检查参数");
        }
    }
}
