package command.admin;

import java.util.List;

import command.AbstractCommand;
import dao.admin.ItemDao;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;

public class GetMaxItemIdCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ItemDao dao = factory.getItemDao();  
		
		List maxId = dao.getMaxItemId();	
		resc.setResult(maxId);
		resc.setTarget("/WEB-INF/adminjsp/ItemRegist.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
