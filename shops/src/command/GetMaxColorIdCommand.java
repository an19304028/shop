package command;

import java.util.List;

import dao.ColorDao;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;

public class GetMaxColorIdCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao();  
		
		List maxId = dao.getMaxColorId();	
		resc.setResult(maxId);
		resc.setTarget("adminjsp/Color");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
