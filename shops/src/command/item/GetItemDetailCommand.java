package command.item;

import java.util.List;

import bean.Item;
import command.AbstractCommand;
import dao.favorite.GetFavoListDao;
import dao.item.GetItemDetailDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetItemDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId=null;
		String itemName=null;
		
		System.out.println(rc.getSessionAttribute("itemId"));
		
		
		if(rc.getSessionAttribute("itemId")==null) {
			itemId = rc.getParameter("itemId")[0];
			itemName = rc.getParameter("itemName")[0];
			
		}else {
			itemId = (String) rc.getSessionAttribute("itemId");
			itemName = (String) rc.getSessionAttribute("itemName");
			rc.removeSessionAttribute("itemId");
			rc.removeSessionAttribute("itemName");
		}
		
		if(itemId.substring(4,4).equals("1")==false){
			String itemId1 = itemId.substring(0,4);
			
			itemId = itemId1 + "1";
			
			System.out.println("アイテムID"+itemId1+" "+itemId);
			
	
		}

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetItemDetailDao dao = factory.getGetItemDetailDao();
		
		rc.setAttribute("itemName", itemName);
		rc.setAttribute("price", dao.getPrice(itemId));
		rc.setAttribute("point", dao.getPoint(itemId));
		rc.setAttribute("itemId",itemId);
		
		List image = dao.getImage(itemId);
		rc.setAttribute("image", image);
		System.out.println("image:"+image);
		
		
		List item = dao.getItemDetail(itemName);
		System.out.println(item);
		
		String detail = dao.getDetail(itemId);
		rc.setAttribute("detail", detail);

		resc.setResult(item);
		if(rc.getSessionAttribute("userId")==null) {
			System.out.println(rc.getAttribute("favoCheck"));
			if(rc.getAttribute("favoCheck")==null) {
				rc.setAttribute("favoCheck", "false");
			}
		}else {
			String userId = (String) rc.getSessionAttribute("userId");
			GetFavoListDao favo = factory.getGetFavoListDao();
			boolean favoCheck = favo.getCheckfavo(userId, itemId);
			rc.setAttribute("favoCheck", favoCheck);
		}

		resc.setTarget("/WEB-INF/userjsp/Item.jsp");
		return resc;
	}
}