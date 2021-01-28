package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/Cart.jsp");
		return resc;
	}

}
