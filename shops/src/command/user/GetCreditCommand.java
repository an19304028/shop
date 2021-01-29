package command.user;

import java.util.List;

import command.AbstractCommand;
import dao.user.GetCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCreditDao dao = factory.getGetCreditDao();
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		//Credit c = new Credit();
		//c.setUserId(userId);
		List credit = dao.getCredit(userId);
		resc.setResult(credit);

		resc.setTarget("/WEB-INF/userjsp/CheckPayment.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
