package command.admin;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.ColorDao;
import presentation.ResponseContext;

public class GetColorListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao(); 
		
		List colors = dao.getAllColors();
		System.out.println(dao.getAllColors());
		
		resc.setResult(colors);
		resc.setTarget("/WEB-INF/adminjsp/Color.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
