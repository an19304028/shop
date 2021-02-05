package command.admin;

import bean.Item;
import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ItemDao;
import presentation.RequestContext;
import presentation.ResponseContext;


public class EditItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0];
		String itemName =rc.getParameter("itemName")[0];
		String stockCount = rc.getParameter("stockCount")[0];
		String price = rc.getParameter("price")[0];
		String detail = rc.getParameter("detail")[0];
		
		
		System.out.println(itemName);
		
		Item i = new Item();
		i.setItemId(itemId);
		i.setItemName(itemName);
		i.setStockCount(Integer.parseInt(stockCount));
		i.setPrice(Integer.parseInt(price));
		i.setDetail(detail);
		
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao();
		dao.EditItem(i);
		rc.setAttribute("mess","変更しました");
		
		resc.setTarget("getitemlist");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
