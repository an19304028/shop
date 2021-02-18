package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputRemindPassCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		resc.setTarget("/WEB-INF/userjsp/remindPass.jsp");
		return resc;
	}

}
