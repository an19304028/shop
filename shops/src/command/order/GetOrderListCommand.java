package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetOrderListDao;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;

public class GetOrderListCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetOrderListDao dao = factory.getGetOrderListDao();

		List orders = dao.getOrderList();
		System.out.println(dao.getOrderList());

		resc.setResult(orders);

		resc.setTarget("/WEB-INF/adminjsp/Purchase.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
