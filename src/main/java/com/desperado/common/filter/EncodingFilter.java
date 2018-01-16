package desperado.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by desperado on 18-1-12.
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class EncodingFilter implements Filter {

    private String ENCODING;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ENCODING = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest htr = (HttpServletRequest) request;
        if ("POST".equals(htr.getMethod())) {
            htr.setCharacterEncoding(ENCODING);
        }
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/json;charset=" + ENCODING);
        chain.doFilter(htr, response);
    }

    @Override
    public void destroy() {}
}
