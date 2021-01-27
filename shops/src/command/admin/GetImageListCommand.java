package command.admin;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;
import dao.admin.GetImageDao;

public class GetImageListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetImageDao dao = factory.getGetImageDao(); 
		
		List image = dao.getImage();
		System.out.println(dao.getImage());
		
		resc.setResult(image);
		resc.setTarget("/WEB-INF/adminjsp/ItemList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
