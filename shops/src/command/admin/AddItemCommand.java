package command.admin;

import bean.Item;
import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ItemDao;
import presentation.RequestContext;
import presentation.ResponseContext;


public class AddItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0];
		String itemName =rc.getParameter("itemName")[0];
		String stockCount = rc.getParameter("stockCount")[0];
		String sizeId = rc.getParameter("sizeId")[0];
		String colorId = rc.getParameter("colorId")[0];
		String price = rc.getParameter("price")[0];
		String categoryId = rc.getParameter("categoryId")[0];
		String detail = rc.getParameter("detail")[0];
		
		
		System.out.println(itemName);
		
		Item i = new Item();
		i.setItemId(itemId);
		i.setItemName(itemName);
		i.setStockCount(Integer.parseInt(stockCount));
		i.setSizeId(sizeId);
		i.setColorId(colorId);
		i.setPrice(Integer.parseInt(price));
		i.setCategoryId(categoryId);
		i.setDetail(detail);
		
	
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao();
		dao.addItem(i);
		rc.setAttribute("mess","商品を追加しました");
		
		
		resc.setTarget("/WEB-INF/adminjsp/Admin.jsp");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
