package presentation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext {
	private Map parameters;
	private HttpServletRequest request;
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
	public void setToken(String token) {
		// TODO 自動生成されたメソッド・スタブ

		 request.getSession(true).setAttribute("token", token);

	}
	@Override
	public String getToken() {
		// TODO 自動生成されたメソッド・スタブ

		return (String)request.getSession(true).getAttribute("token");
	}
	@Override
	public String getOldPath() {
		// TODO 自動生成されたメソッド・スタブ
		return (String)request.getSession(true).getAttribute("oldPath");
	}
	@Override
	public void invalidateSession() {
		// TODO 自動生成されたメソッド・スタブ

		request.getSession(true).invalidate();

	}

}
