package command.user;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class InputUserRegistCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		User u = new User();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		InputUserRegistDao dao = factory.getInputUserRegistDao();

		dao.User(u);

		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		return resc;
	}

}
