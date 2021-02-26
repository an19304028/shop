package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import dao.user.GetCreditDao;
import dao.user.GetUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class InputOrderCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCreditDao dao = factory.getGetCreditDao();
		RequestContext rc = getRequestContext();
		String userId = (String) rc.getSessonAttribute("userId");
		String point = rc.getParameter("point")[0];
		rc.setAttribute("itempoint", point);
		
		GetUserDao user = factory.getGetUserDao(); 
		List users = user.getUser(userId);
		
		rc.setAttribute("userInfo", users);

		//Credit c = new Credit();
		//c.setUserId(userId);
		List credit = dao.getCredit(userId);
		if(credit.size()==0) {
			rc.setAttribute("credit", 0);
		}
		rc.setAttribute("creditData", credit);
		resc.setResult(credit);
		resc.setTarget("/WEB-INF/userjsp/Payment.jsp");
		return resc;
	}

}
