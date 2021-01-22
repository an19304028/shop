package command.admin;

import command.AbstractCommand;
import dao.admin.RemoveImageDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveImageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String imageId = rc.getParameter("imageId")[0]; 
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveImageDao dao = factory.getRemoveImageDao();
		System.out.println("削除"+imageId);
		dao.removeImage(imageId);
		
		resc.setMess(imageId+"を削除しました");
		
		resc.setTarget("getitemlist");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}

}
