package command.order;

import java.util.ArrayList;

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

		String userId =rc.getParameter("userId")[0];
		//String itemId= rc.getParameter("itemId")[0];
		int price = Integer.parseInt(rc.getParameter("price")[0]);
		int itemCount = Integer.parseInt(rc.getParameter("itemCount")[0]);
		//int buyCount = Integer.parseInt(rc.getParameter("buyCount")[0]);
		System.out.println(userId + "\t"+price + "\t"+itemCount);

		ArrayList list = new ArrayList();
		//for文でparameter全部引っ張り出す
		for(int i = 0; i< rc.getParameter("itemId").length; i++) {
			OrderDetail od = new OrderDetail();
			od.setItemId(rc.getParameter("itemId")[i]);
			od.setBuyCount(Integer.parseInt(rc.getParameter("buyCount")[i]));

			list.add(od);

			System.out.println("item_id:"+rc.getParameter("itemId")[i]+"\tbuy_count:"+rc.getParameter("buyCount")[i]);
		}

		Order o = new Order();

		o.setUserId(userId);
		o.setPrice(price);
		o.setItemCount(itemCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddOrderDao dao = factory.getAddOrderDao();

		dao.addOrder(o, list);

		resc.setMess("注文情報を確定いたしました。");

		resc.setTarget("/WEB-INF/userjsp/Purchase.jsp");
		System.out.println("target:"+resc.getTarget());

		return null;
	}

}
