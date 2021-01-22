package command.user;

import bean.Credit;
import command.AbstractCommand;
import dao.user.GetCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		Credit c = new Credit();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCreditDao dao = factory.getGetCreditDao();


		resc.setMess("");

		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
