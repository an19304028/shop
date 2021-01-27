package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputUserRegistCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		return resc;
	}

}
