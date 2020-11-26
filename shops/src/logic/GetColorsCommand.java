package logic;

import java.util.List;

import integration.AbstractDaoFactory;
import integration.ColorDao;
import presentation.ResponseContext;

public class GetColorsCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao(); 
		
		List colors = dao.getAllColors();
		System.out.println(dao.getAllColors());
		
		resc.setResult(colors);
		resc.setMess("追加しました");
		resc.setTarget("adminjsp/Color");
		System.out.println(resc.getTarget());
		return resc;
	}
}
