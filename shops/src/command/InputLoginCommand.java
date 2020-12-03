package command;

import presentation.ResponseContext;

public class InputLoginCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("/WEB-INF/userjsp/Login.jsp");
		return resc;
	}

}
