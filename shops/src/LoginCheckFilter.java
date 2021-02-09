

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/LoginCheckFilter")
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		request.setCharacterEncoding("utf-8");

		HttpServletRequest hreq = (HttpServletRequest)request;

		HttpSession session = hreq.getSession(true);
		/*String pathInfo = ((HttpServletRequest) request).getPathInfo();
		System.out.println(pathInfo);*/

		if(session.getAttribute("token")==null) {

			request.setAttribute("itemId",hreq.getParameter("itemId"));
			request.setAttribute("buyCount",hreq.getParameter("buyCount"));
			session.setAttribute("oldPath", hreq.getServletPath());
			System.out.println("filter");

			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/userjsp/Login.jsp");

			disp.forward(request, response);

		}else {
			System.out.println("filter");
			chain.doFilter(request, response);

		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
