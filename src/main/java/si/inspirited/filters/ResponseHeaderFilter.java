package si.inspirited.filters;

/**
 * @author Jesus Lord Almighty
 * at 25.01.2018
 */

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.*;

public class ResponseHeaderFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Map httpParams = new HashMap();

    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration enums = filterConfig.getInitParameterNames();
        while(enums.hasMoreElements()) {
            final String name = (String)enums.nextElement();
            final String value = filterConfig.getInitParameter(name);
            log.debug("HTTP-header registred - {}:{}", name, value);
            httpParams.put(name, value);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        /*for (Entry entry : httpParams.entrySet()) {
            httpResponse.setHeader(entry.getKey(), entry.getValue());
        }*/
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}