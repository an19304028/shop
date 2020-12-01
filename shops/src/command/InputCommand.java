package command;

import java.util.HashMap;

import presentation.ResponseContext;

public class InputCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("adminjsp/Admin");
		return resc;
	}

}
