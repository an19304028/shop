package command.admin;

import command.AbstractCommand;
import dao.admin.ItemDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0]; 
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao();
		System.out.println("削除"+itemId);
		dao.removeItem(itemId);
		
		rc.setAttribute("mess",itemId+"を削除しました");
		
		resc.setTarget("getitemlist");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}

}
