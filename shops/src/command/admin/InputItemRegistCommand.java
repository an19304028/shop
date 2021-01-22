package command.admin;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputItemRegistCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("/WEB-INF/adminjsp/ItemRegist.jsp");
		return resc;
	}

}