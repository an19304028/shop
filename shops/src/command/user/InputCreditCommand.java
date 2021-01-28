package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputCreditCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/Payment.jsp");
		return resc;
	}

}
