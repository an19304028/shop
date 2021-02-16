package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import dao.user.GetCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class InputOrderCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCreditDao dao = factory.getGetCreditDao();
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		//Credit c = new Credit();
		//c.setUserId(userId);
		List credit = dao.getCredit(userId);
		resc.setResult(credit);
		resc.setTarget("/WEB-INF/userjsp/Payment.jsp");
		return resc;
	}

}
