package presentation;

public interface ResponseContext {
	void setResult(Object bean);
	Object getResult();
	void setTarget(String transferInfo);
	String getTarget();
	void setResponse(Object res);
	Object getResponse();
	String getMess();
	void setMess(String mess);
}
