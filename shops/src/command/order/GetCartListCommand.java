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

		List cart = dao.getCartList(rc.getParameter("userId")[0]);
		System.out.println(dao.getCartList(rc.getParameter("userId")[0]));

		resc.setResult(cart);
		resc.setTarget("/WEB-INF/userjsp/Cart.jsp");

		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
