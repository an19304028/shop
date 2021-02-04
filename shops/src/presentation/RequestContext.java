package presentation;

public interface RequestContext {
	public abstract String getCommandPath();
	public abstract String[] getParameter(String key);
	public abstract void setRequest(Object req);
	public abstract Object getRequest();

	public abstract void setToken(String token);
	public abstract String getToken();
	public abstract String getOldPath();
	public abstract void invalidateSession();
	
	public abstract void setAttribute(String key, Object o);
	public abstract Object getAttribute(String key);
	
	public abstract void setSessionAttribute(String key, Object o);
	public abstract Object getSessonAttribuet(String key);
}
