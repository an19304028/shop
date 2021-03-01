package command.order;

import bean.Cart;
import command.AbstractCommand;
import dao.order.AddCartDao;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddCartCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		System.out.println("AddCartCommandだよ");
		
		String userId = (String)rc.getSessionAttribute("userId");
		System.out.println("USERID:" + (String)rc.getSessionAttribute("userId"));
		
		String itemId=null;
		String buyCount=null;
		
		if(rc.getSessionAttribute("itemId")==null) {
			itemId = rc.getParameter("itemId")[0];
			buyCount = rc.getParameter("buyCount")[0];
		}else {
			itemId = (String) rc.getSessionAttribute("itemId");
			buyCount = (String) rc.getSessionAttribute("buyCount");
			rc.removeSessionAttribute("itemId");
			rc.removeSessionAttribute("buyCount");
		}
		
		
		
		int buyCount2 = Integer.parseInt(buyCount);
	
		System.out.println("BUYCOUNT:" + rc.getParameter("buyCount")[0]);

		System.out.println(userId +"\t"+itemId+"\t"+buyCount);

		Cart c = new Cart();
		c.setUserId(userId);
		c.setItemId(itemId);
		c.setBuyCount(buyCount2);
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddCartDao dao = factory.getAddCartDao();

		int stock = dao.getStockCount(c);
		int cartcount = dao.getCartCount(c);

		System.out.println(stock+"\t"+cartcount);
		if(stock>=buyCount2+cartcount) {
			dao.addCart(c);
			rc.setAttribute("mess1",itemId+"を"+buyCount+"個カートに追加しました");
			resc.setTarget("getcartlist");
			LoginDao cart = factory.getLoginDao();
			String cartCount = cart.getCartCount(userId);
			
			String buyCount1 = cart.getBuyCount(userId);
			rc.setSessionAttribute("buyCount", buyCount1);
			System.out.println("buyCount"+buyCount1);
			
			rc.setSessionAttribute("cartCount", cartCount);
		}else if(stock<buyCount2+cartcount) {
			rc.setAttribute("mess1","すでにカートに入っているか、在庫が足りません");
			resc.setTarget("getitemdetail");
		}



		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
