package command.order;

import java.util.List;

import command.AbstractCommand;
import dao.order.GetCartListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetOrderCheckCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = (String)rc.getSessionAttribute("userId");
		String usepoint = rc.getParameter("usepoint")[0];
		String itempoint = rc.getParameter("itempoint")[0];
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCartListDao dao = factory.getGetCartListDao();

		String name = rc.getParameter("name")[0];
		String address = rc.getParameter("address")[0];
		String postalCode = rc.getParameter("postalCode")[0];
		String rs = rc.getParameter("rs")[0];

		rc.setAttribute("name",name);
		rc.setAttribute("address", address);
		rc.setAttribute("postalCode", postalCode);

		if(rs.equals("1")) {
			rc.setAttribute("pay", "クレジットカード");
		}else if(rs.equals("2")) {
			rc.setAttribute("pay", "現金");
		}

		int point = dao.getPoint(userId);
		int price = dao.getTotalAmount(userId);
		System.out.println(point);
		rc.setAttribute("point", usepoint);
		rc.setAttribute("itempoint", itempoint);

		int cartPoint = (int) rc.getSessionAttribute("cartPoint");
		int totalPrice = price - Integer.parseInt(usepoint);
		rc.setAttribute("price", price);
		rc.setSessionAttribute("totalPrice", totalPrice);

		int total = price-Integer.parseInt(usepoint);
		rc.setAttribute("total",total);
		List cart = dao.getCartList(userId);
		resc.setResult(cart);
		resc.setTarget("/WEB-INF/userjsp/OrderCheck.jsp");
		return resc;
	}

}
