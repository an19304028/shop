package command;

import presentation.ResponseContext;

public class UserRegistInputCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("userjsp/UserRegist");
		return resc;
	}

}
