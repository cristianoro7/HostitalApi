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
@WebServlet(urlPatterns = "/admin/consultingroom/add", initParams = @WebInitParam(name = "result",
        value = "/admin/consultingroom.result"))
public class AddConsultingRoomController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentId = req.getParameter("departmentId");
        String location = req.getParameter("location");
        ConsultingRoomResult.ConsultingRoom room = new ConsultingRoomResult.ConsultingRoom(location);
        room.setDepartmentId(departmentId);

        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        ConsultingRoomService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_ROOM_SERVICE);
        if (VerifyHelper.nonNull(room.getLocation()) && !VerifyHelper.isEmpty(room.getLocation())
                && VerifyHelper.nonNull(room.getDepartmentId()) && !VerifyHelper.isEmpty(room.getDepartmentId())) {
            roomResult = service.addRoom(room);
        }
        render(req, resp, "roomResult", roomResult);
    }
}
