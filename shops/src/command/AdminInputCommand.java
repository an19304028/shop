package command;

import presentation.ResponseContext;

public class AdminInputCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("adminjsp/Admin");
		return resc;
	}

}
