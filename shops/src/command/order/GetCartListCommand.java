package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCartListCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCartListDao dao = factory.getGetCartListDao();

		String userId = rc.getParameter("userId")[0];

		List cart = dao.getCartList(userId);
		System.out.println(dao.getCartList(rc.getParameter("userId")[0]));

		String total = Integer.toString(dao.getTotalAmount(userId));

		resc.setMess(total);

		resc.setResult(cart);
		resc.setTarget("/WEB-INF/userjsp/Cart.jsp");

		System.out.println("target:"+resc.getTarget());
		return resc;
	}



}
