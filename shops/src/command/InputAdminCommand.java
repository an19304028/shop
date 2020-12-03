package command;

import presentation.ResponseContext;

public class InputAdminCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
	
		resc.setTarget("/WEB-INF/adminjsp/Admin.jsp");
		return resc;
	}

}
