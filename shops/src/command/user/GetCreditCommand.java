package command.user;

import dao.user.GetCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCreditCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		User u = new User();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCreditDao dao = factory.getGetCreditDao();

		dao.addUser(u);
		resc.setMess("");

		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
