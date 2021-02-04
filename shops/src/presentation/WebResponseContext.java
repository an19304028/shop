package presentation;

import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext {
	private Object result;
	private String target;
	private String mess;
	private HttpServletResponse response;
	@Override
	public void setResult(Object bean) {
		result = bean;
		
	}

	@Override
	public Object getResult() {

		return result;
	}

	@Override
	public void setTarget(String transferInfo) {
		target=transferInfo;
		
	}

	@Override
	public String getTarget() {

		return target;
	}

	@Override
	public void setResponse(Object res) {
		response = (HttpServletResponse)res;
		
	}

	@Override
	public Object getResponse() {

		return response;
	}



}
