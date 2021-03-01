package command.order;

import bean.Cart;
import command.AbstractCommand;
import dao.order.AddCartDao;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class EditCartCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		
		String userId = (String)rc.getSessionAttribute("userId");
		System.out.println("USERID:" + (String)rc.getSessionAttribute("userId"));

		String itemId = rc.getParameter("itemId")[0];
		System.out.println("ITEMID:" + rc.getParameter("itemId")[0]);


		int buyCount = Integer.parseInt(rc.getParameter("buyCount")[0]);
		System.out.println("BUYCOUNT:" + rc.getParameter("buyCount")[0]);

		System.out.println(userId +"\t"+itemId+"\t"+buyCount);

		Cart c = new Cart();
		c.setUserId(userId);
		c.setItemId(itemId);
		c.setBuyCount(buyCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddCartDao dao = factory.getAddCartDao();
		
		

		int stock = dao.getStockCount(c);
		int cartcount = dao.getCartCount(c);

		System.out.println(stock+"\t"+cartcount);
		if(stock>=buyCount) {
			dao.editCart(c);
			rc.setAttribute("edit","編集しました");
			
			LoginDao cart = factory.getLoginDao();
			String cartCount = cart.getCartCount(userId);
			rc.setSessionAttribute("cartCount", cartCount);
			
			String buyCount1 = cart.getBuyCount(userId);
			rc.setSessionAttribute("buyCount", buyCount1);
			System.out.println("buyCount"+buyCount1);
			
			resc.setTarget("getcartlist");
		}else if(stock<buyCount) {
			rc.setAttribute("edit","在庫が足りません");
			resc.setTarget("getcartlist");
		}



		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
