package command;

import java.util.List;

import dao.AbstractDaoFactory;
import dao.ColorDao;
import presentation.ResponseContext;

public class GetColorsCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao(); 
		
		List colors = dao.getAllColors();
		System.out.println(dao.getAllColors());
		
		resc.setResult(colors);
		resc.setMess("カラーを追加しました");
		System.out.println("メッセージ:"+resc.getMess());
		resc.setTarget("adminjsp/Color");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
