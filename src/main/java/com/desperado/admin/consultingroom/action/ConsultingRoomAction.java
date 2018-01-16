package desperado.admin.consultingroom.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.consultingroom.domain.ConsultingRoomResult;
import desperado.base.BaseAction;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/admin/consultingroom.result")
public class ConsultingRoomAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConsultingRoomResult result = (ConsultingRoomResult) request.getAttribute("roomResult");
        if (result.isSuccess()) {
            printSuccess(response, result);
        } else {
            printError(response, ResultCodeHelper.CODE_ACCOUNT_OR_PASSWORD_ERROR, "参数错误, 请检查参数");
        }
    }
}
