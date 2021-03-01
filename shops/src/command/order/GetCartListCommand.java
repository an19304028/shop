package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCartListCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCartListDao dao = factory.getGetCartListDao();

		String userId = (String)rc.getSessionAttribute("userId");

		List cart = dao.getCartList(userId);

		String total = Integer.toString(dao.getTotalAmount(userId));
		if(total.equals("0")) {
			rc.setAttribute("mess","カートの中身がありません");
			rc.setAttribute("total", 0);
		}else {
			rc.setSessionAttribute("total1",total);
			int point = dao.getPoint(userId);
			System.out.println(point);
			rc.setSessionAttribute("cartPoint", point);
			rc.setAttribute("total", 1);
			LoginDao login = factory.getLoginDao();
			String buyCount1 = login.getBuyCount(userId);
			rc.setSessionAttribute("buyCount", buyCount1);
		}
		resc.setResult(cart);
		resc.setTarget("/WEB-INF/userjsp/Cart.jsp");
		System.out.println(rc.getAttribute("total"));
		System.out.println("target:"+resc.getTarget());
		return resc;
	}



}
