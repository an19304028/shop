package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetOrderCheckCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = (String)rc.getSessonAttribute("userId");
		String usepoint = rc.getParameter("usepoint")[0];
		String itempoint = rc.getParameter("itempoint")[0];
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCartListDao dao = factory.getGetCartListDao();
		
		int point = dao.getPoint(userId);
		System.out.println(point);
		rc.setAttribute("point", usepoint);
		rc.setAttribute("itempoint", itempoint);

		List cart = dao.getCartList(userId);
		resc.setResult(cart);
		resc.setTarget("/WEB-INF/userjsp/OrderCheck.jsp");
		return resc;
	}

}
