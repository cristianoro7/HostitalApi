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
import desperado.common.helper.VerifyHelper;

/**
 * Created by desperado on 18-1-13.
 */
@WebServlet(urlPatterns = "/admin/title/add", initParams = @WebInitParam(name = "result", value = "/admin/title.result"))
public class AddTitleController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        TitleResult.Title t = new TitleResult.Title(title);
        TitleResult titleResult = new TitleResult();

        if (VerifyHelper.verifiedAddTitle(t)) {
            titleResult.addTitle(t);
            TitleService service = ServiceContainer.getInstance().getService(ServiceNameContract.ADMIN_TITLE_SERVICE);
            service.addTitle(titleResult);
        }
        render(req, resp, "titleResult", titleResult);
    }
}
