package command.order;

import java.util.ArrayList;

import bean.Order;
import bean.OrderDetail;
import command.AbstractCommand;
import dao.order.AddOrderDao;
import dao.order.RemoveAllCartDao;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddOrderCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String usepoints = rc.getParameter("usepoint")[0];
		String userId =rc.getParameter("userId")[0];
		//String itemId= rc.getParameter("itemId")[0];
		int price = 0;
		//int itemCount = Integer.parseInt(rc.getParameter("itemCount")[0]);
		int itemCount = 0;
		//int buyCount = Integer.parseInt(rc.getParameter("buyCount")[0]);
		int point = Integer.parseInt((String) rc.getParameter("itempoint")[0]);
		int usepoint = Integer.parseInt(usepoints);

		ArrayList list = new ArrayList();
		//for文でparameter全部引っ張り出す
		for(int i = 0; i< rc.getParameter("itemId").length; i++) {
			OrderDetail od = new OrderDetail();
			od.setItemId(rc.getParameter("itemId")[i]);
			od.setBuyCount(Integer.parseInt(rc.getParameter("buyCount")[i]));

			list.add(od);
			itemCount += Integer.parseInt(rc.getParameter("buyCount")[i]);
			price += Integer.parseInt(rc.getParameter("price")[i])*Integer.parseInt(rc.getParameter("buyCount")[i]);

			System.out.println("item_id:"+rc.getParameter("itemId")[i]+"\tbuy_count:"+rc.getParameter("buyCount")[i]+"\tprice:"+rc.getParameter("price")[i]);

		}

		Order o = new Order();

		o.setUserId(userId);
		o.setPrice(price);
		o.setItemCount(itemCount);

		System.out.println(userId + "\t"+price + "\t"+itemCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddOrderDao dao = factory.getAddOrderDao();

		dao.addOrder(o, list, point,usepoint);

		rc.setAttribute("mess","注文情報を確定いたしました。");

		RemoveAllCartDao removedao = factory.getRemoveAllCartDao();

		removedao.removeAllCart(userId);
		
		rc.removeSessionAttribute("cartCount");
		rc.removeSessionAttribute("cartPoint");
		rc.removeSessionAttribute("total1");
		rc.removeSessionAttribute("totalPrice");
		
		LoginDao login = factory.getLoginDao();
		int points = login.getPoint(userId);
		rc.setSessionAttribute("userPoint", points);
		System.out.println(rc.getSessionAttribute("userPoint"));

		resc.setTarget("/WEB-INF/userjsp/Purchase.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
