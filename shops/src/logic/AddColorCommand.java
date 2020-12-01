package logic;

import integration.AbstractDaoFactory;
import integration.ColorDao;
import integration.ColorDao;
import bean.Color;
import presentation.RequestContext;
import presentation.ResponseContext;


public class AddColorCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String colorId = rc.getParameter("colorId")[0];
		String colorName = rc.getParameter("colorName")[0];
		String colorImagePath = rc.getParameter("colorImagePath")[0];
		System.out.println(colorId + "\t"+colorName+"\t"+colorImagePath);
		
		Color c = new Color();
		c.setColorId(colorId);
		c.setColorName(colorName);
		c.setColorImagePath(colorImagePath);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ColorDao dao = factory.getColorDao();
		dao.addColor(c);
		
		if(dao.getColor(colorId)!=null) {
			resc.setMess("この番号は使われています");
		}//else{
			
			//resc.setMess("カラーを追加しました");
		//}*/
		
		resc.setTarget("adminjsp/Admin");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
