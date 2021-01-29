package command.order;

import bean.Order;
import bean.OrderDetail;
import command.AbstractCommand;
import dao.order.AddOrderDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddOrderCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		//変更するかもしれない
		String userId =rc.getParameter("userId")[0];
		String itemId= rc.getParameter("itemId")[0];
		int price = Integer.parseInt(rc.getParameter("price")[0]);
		int itemCount = Integer.parseInt(rc.getParameter("itemCount")[0]);
		int buyCount = Integer.parseInt(rc.getParameter("buyCount")[0]);
		System.out.println(userId + "\t"+itemId + "\t"+price + "\t"+itemCount);


		Order o = new Order();
		OrderDetail od = new OrderDetail();

		o.setUserId(userId);
		o.setPrice(price);
		o.setItemCount(itemCount);
		od.setItemId(itemId);
		od.setBuyCount(buyCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddOrderDao dao = factory.getAddOrderDao();

		resc.setMess("注文情報を確定いたしました。");

		resc.setTarget("/WEB-INF/userjsp/Purchase.jsp");
		System.out.println("target:"+resc.getTarget());

		return null;
	}

}
