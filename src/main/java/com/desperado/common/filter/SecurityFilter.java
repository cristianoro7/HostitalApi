package desperado.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import desperado.admin.user.domain.UserResult;
import desperado.common.domain.Result;
import desperado.common.helper.GsonHelper;
import desperado.common.helper.ResultCodeHelper;
import desperado.common.security.SecurityProtector;

/**
 * Created by desperado on 18-1-12.
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "login", value = "/login"))
public class SecurityFilter implements javax.servlet.Filter {

    private String LOGIN;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGIN = filterConfig.getInitParameter("login");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest htr = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (isLoginUrl(htr, LOGIN)) {
            chain.doFilter(htr, response);
        } else if (isLogin(htr)) {
            UserResult.User user = (UserResult.User) htr.getSession().getAttribute("user");
            if (SecurityProtector.canAccessProtectResource(htr.getServletPath(), user)) { //有点hardcode的感觉...
                chain.doFilter(htr, response);
            } else {
                rejectAccess(resp, ResultCodeHelper.CODE_ACCESS_ERROR, "无权限访问!");
            }
        } else {
            rejectAccess(resp, ResultCodeHelper.CODE_NOT_LOGIN, "未登录/session过期!");
        }
    }

    private boolean isLoginUrl(HttpServletRequest request, String loginUrl) {
        return request.getServletPath().equals(loginUrl);
    }

    private boolean isLogin(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }

    private void rejectAccess(HttpServletResponse response, int errorCode, String rejectMsg) throws IOException {
        response.getWriter().println(GsonHelper.toJson(Result.buildResult(errorCode, rejectMsg, false)));
    }

    @Override
    public void destroy() {
    }
}
