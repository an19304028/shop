package command.admins;

import command.AbstractCommand;
import dao.admin.ColorDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveColorCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String colorId = rc.getParameter("colorId")[0]; 
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao();
		System.out.println("削除"+colorId);
		dao.removeColor(colorId);
		
		resc.setMess(colorId+"を削除しました");
		
		resc.setTarget("getcolors");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}

}
