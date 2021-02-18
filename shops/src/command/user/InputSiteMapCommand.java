package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputSiteMapCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/SiteMap.jsp");
		return resc;
	}

}
