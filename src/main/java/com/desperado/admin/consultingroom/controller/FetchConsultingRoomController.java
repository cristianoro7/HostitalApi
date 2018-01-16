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

/**
 * Created by desperado on 18-1-14.
 */
@WebServlet(urlPatterns = {"/admin/consultingrooms", "/admin/consultingroom"},
        initParams = @WebInitParam(name = "result",
                value = "/admin/consultingroom.result"))
public class FetchConsultingRoomController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ConsultingRoomResult roomResult;
        ConsultingRoomService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_ROOM_SERVICE);
        if (id != null) {
            roomResult = service.listRoomByDepartmentId(Integer.parseInt(id));
        } else {
            roomResult = service.listRooms();
        }
        render(req, resp, "roomResult", roomResult);
    }
}
