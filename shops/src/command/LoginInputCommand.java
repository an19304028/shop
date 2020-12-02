package command;

import presentation.ResponseContext;

public class LoginInputCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("userjsp/Login");
		return resc;
	}

}
