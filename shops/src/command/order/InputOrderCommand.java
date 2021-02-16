package command.order;

import command.AbstractCommand;
import presentation.RequestContext;
import presentation.ResponseContext;

public class InputOrderCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0];
		String buyCount = rc.getParameter("buyCount")[0];
		String price = rc.getParameter("price")[0];
		String userId =rc.getParameter("userId")[0];
		String point = rc.getParameter("point")[0];
		
		rc.setSessionAttribute("itemId",itemId );
		rc.setSessionAttribute("buyCount", buyCount);
		rc.setSessionAttribute("price", price);
		rc.setSessionAttribute("point", point);
	
		
		resc.setTarget("/WEB-INF/userjsp/Payment.jsp");
		return resc;
	}

}
