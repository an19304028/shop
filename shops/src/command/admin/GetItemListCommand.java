package command.admin;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ItemDao;
import presentation.ResponseContext;

public class GetItemListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao(); 
		
		List items = dao.getAllItem();
		System.out.println(dao.getAllItem());
		
		resc.setResult(items);
		resc.setTarget("/WEB-INF/adminjsp/ItemList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
