package command.item;

import command.AbstractCommand;
import presentation.RequestContext;

public class GetItemDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0];
		String itemName = rc.getParameter("itemName")[0];
		String stockCount = rc.getParameter("stockCount")[0];
		String colorId = rc.getParameter("colorId")[0];
		String price = rc.getParameter("price")[0];
		String categoryId = rc.getParameter("categoryId")[0];
		String detail = rc.getParameter("detail")[0];
		String imageId = rc.getParameter("imageId")[0];

		resc.setTarget("/WEB-INF/userjsp/Item.jsp");
		return resc;
	}
}
