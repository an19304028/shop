package command.user;

import command.AbstractCommand;
import dao.user.GetPasswordDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;
import sun.security.util.Password;

public class GetPasswordCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		Password p = new Password();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetPasswordDao dao = factory.getGetPasswordDao();

		resc.setMess("");


		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}