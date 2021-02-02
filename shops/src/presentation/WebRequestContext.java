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
	public void setFlag(String flag) {
		// TODO 自動生成されたメソッド・スタブ

		 request.getSession().setAttribute("flag", flag);

	}
	@Override
	public String getFlag() {
		// TODO 自動生成されたメソッド・スタブ

		return (String)request.getSession().getAttribute("flg");
	}
	@Override
	public String getOldPath() {
		// TODO 自動生成されたメソッド・スタブ
		return (String)request.getSession().getAttribute("oldPath");
	}

}
