package presentation;

public interface ResponseContext {
	void setResult(Object bean);
	Object getResult();
	void setTarget(String transferInfo);
	String getTarget();
	void setResponse(Object res);
	Object getResponse();
	void setResult2(Object bean);
	Object getResult2();
	
}
