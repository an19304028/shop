package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputEditPassCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		resc.setTarget("/WEB-INF/userjsp/RemindPassForm.jsp");
		return resc;
	}

}
