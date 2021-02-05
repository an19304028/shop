package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputGuideCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/Guide.jsp");
		return resc;
	}

}
