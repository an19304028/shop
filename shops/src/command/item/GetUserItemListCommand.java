package command.item;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ItemDao;
import dao.item.GetUserItemListDao;
import presentation.ResponseContext;

public class GetUserItemListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetUserItemListDao dao = factory.getGetUserItemListDao(); 
		
		List items = dao.getGetUserItemList();
		System.out.println(items);
		
		resc.setResult(items);
		resc.setTarget("/WEB-INF/userjsp/ItemList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
