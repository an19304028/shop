package command.order;

import bean.Cart;
import command.AbstractCommand;
import dao.order.AddCartDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddCartCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];
		String itemId = rc.getParameter("itemId")[0];
		int buyCount = Integer.parseInt(rc.getParameter("buyCount")[0]);
		System.out.println(userId +"\t"+itemId+"\t"+buyCount);

		Cart c = new Cart();
		c.setUserId(userId);
		c.setItemId(itemId);
		c.setBuyCount(buyCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddCartDao dao = factory.getAddCartDao();

		dao.addCart(c);

		resc.setMess(itemId+"を"+buyCount+"個カートに追加しました");

		resc.setTarget("/WEB-INF/userjsp/Cart.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
