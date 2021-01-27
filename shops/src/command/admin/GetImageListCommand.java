package command.admin;

import java.util.List;

import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;
import dao.admin.GetImageDao;

public class GetImageListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetImageDao dao = factory.getGetImageDao();
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0]; 
		
		List image = dao.getImage(itemId);
		System.out.println(dao.getImage(itemId));
		
		resc.setResult(image);
		resc.setTarget("/WEB-INF/adminjsp/ItemList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
