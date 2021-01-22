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
		String imageId = rc.getParameter("imageId")[0];
		String imagePath = rc.getParameter("imagePath")[0];
		System.out.println(imageId + "\t"+"\t"+imagePath);
		
		Image i = new Image();
		i.setImageId(imageId);
		i.setImagePath(imagePath);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddImageDao dao = factory.getAddImageDao();
		dao.addImage(i);
		resc.setMess("画像を追加しました");
		
		
		resc.setTarget("/WEB-INF/adminjsp/Admin.jsp");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
