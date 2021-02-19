package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetOrderListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetOrderListCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RequestContext rc = getRequestContext();
		String userId = (String) rc.getSessonAttribute("userId");
		GetOrderListDao dao = factory.getGetOrderListDao();

		List orders = dao.getOrderList(userId);
		System.out.println(orders);
		resc.setResult(orders);
		if(orders.size()==0) {
			rc.setAttribute("history", 0);
		}else {
			rc.setAttribute("history", 1);
		}

		resc.setTarget("/WEB-INF/userjsp/History.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
