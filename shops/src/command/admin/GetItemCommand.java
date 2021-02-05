package command.admin;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ItemDao;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetItemCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao(); 
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0]; 
		
		List items = dao.getItem(itemId);
		System.out.println(items);
		
		resc.setResult(items);
		resc.setTarget("/WEB-INF/adminjsp/ItemEdit.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
