package presentation;

public interface ApplicationController {
	public abstract RequestContext getRequest (Object request);
	public abstract ResponseContext handleRequest(RequestContext req);
	public abstract void handleResponse(RequestContext req, ResponseContext res);
}
