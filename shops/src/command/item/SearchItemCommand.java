package command.item;

import java.util.List;

import command.AbstractCommand;
import dao.item.GetUserItemListDao;
import dao.item.SearchItemDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class SearchItemCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		
		RequestContext rc = getRequestContext();
		String key = rc.getParameter("key")[0]; 
		SearchItemDao dao = factory.getSearchItemDao(); 
		
		List items = dao.searchItem(key);
		System.out.println(items);
		
		resc.setResult(items);
		resc.setTarget("/WEB-INF/userjsp/ItemList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
