package presentation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebRequestContext implements RequestContext {
	private Map parameters;
	private HttpServletRequest request;
	private HttpSession hsession = request.getSession();
	public WebRequestContext() {}
	@Override
	public String getCommandPath() {
		String pathInfo=request.getServletPath();
		String commandPath=pathInfo.substring(1);
		System.out.println("パス:"+commandPath);
		return commandPath;
	}

	@Override
	public String[] getParameter(String key) {
		return (String[]) parameters.get(key);
	}

	@Override
	public void setRequest(Object req) {
		request = (HttpServletRequest)req;
		parameters = request.getParameterMap();

	}

	@Override
	public Object getRequest() {
		return request;
	}
	@Override
	public void setSession(String flg) {
		// TODO 自動生成されたメソッド・スタブ

		hsession.setAttribute("flg", flg);

	}
	@Override
	public String getSession() {
		// TODO 自動生成されたメソッド・スタブ

		return (String) hsession.getAttribute("flg");
	}

}
