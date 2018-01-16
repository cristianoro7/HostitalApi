package desperado.admin.consultingroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.consultingroom.domain.ConsultingRoomResult;
import desperado.admin.consultingroom.service.ConsultingRoomService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = "/admin/consultingroom/delete", initParams = @WebInitParam(name = "result",
        value = "/admin/consultingroom.result"))
public class DeleteConsultingRoomController extends BaseController{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ConsultingRoomResult result = new ConsultingRoomResult();
        ConsultingRoomService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_ROOM_SERVICE);
        if (VerifyHelper.nonNull(id) && !VerifyHelper.isEmpty(id)) {
            result = service.deleteRoom(Integer.parseInt(id));
        }
        render(req, resp, "roomResult", result);
    }
}
