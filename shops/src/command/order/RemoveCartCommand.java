package command.order;

import command.AbstractCommand;
import dao.order.RemoveCartDao;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveCartCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];
		String itemId = rc.getParameter("itemId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCartDao dao = factory.getRemoveCartDao();

		System.out.println("カートから削除:"+itemId);
		dao.removeCart(userId, itemId);
		
		LoginDao cart = factory.getLoginDao();
		String cartCount = cart.getCartCount(userId);
		rc.setSessionAttribute("cartCount", cartCount);
		
		String buyCount1 = cart.getBuyCount(userId);
		rc.setSessionAttribute("buyCount", buyCount1);
		System.out.println("buyCount"+buyCount1);

		rc.setAttribute("mess","カートから"+itemId+"を削除しました");

		resc.setTarget("getcartlist");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
