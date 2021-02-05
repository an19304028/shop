package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputContactCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/Contact.jsp");
		return resc;
	}

}
