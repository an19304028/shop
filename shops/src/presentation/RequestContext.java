package presentation;

public interface RequestContext {
	public abstract String getCommandPath();
	public abstract String[] getParameter(String key);
	public abstract void setRequest(Object req);
	public abstract Object getRequest();
}
