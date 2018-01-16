package desperado.admin.title.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.title.domain.TitleResult;
import desperado.admin.title.service.TitleService;
import desperado.base.BaseController;
import desperado.base.ServiceContainer;
import desperado.base.ServiceNameContract;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = {"/admin/titles", "/admin/title"}, initParams = @WebInitParam(name = "result", value = "/admin/title.result"))
public class FetchTitleController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        TitleService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_TITLE_SERVICE);
        TitleResult result;
        if (id != null) {
            result = service.getTitleById(id);
        } else {
            result = service.listTitle();
        }
        render(req, resp, "titleResult", result);
    }
}
