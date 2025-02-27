package command.admin;

import bean.Image;
import command.AbstractCommand;
import daofactory.AbstractDaoFactory;
import dao.admin.AddImageDao;
import presentation.RequestContext;
import presentation.ResponseContext;


public class AddImageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String imagePath = rc.getParameter("imagePath")[0];
		String itemId = rc.getParameter("itemId")[0];
		System.out.println(imagePath);
		
		Image i = new Image();
		i.setImagePath(imagePath);
		i.setItemId(itemId);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddImageDao dao = factory.getAddImageDao();
		

		dao.addImage(i);
		
		resc.setTarget("getitemlist");
		rc.setAttribute("addimage",(Object)"画像を追加しました");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
