package presentation;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
	
}
