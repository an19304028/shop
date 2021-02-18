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
		String itemId = rc.getParameter("itemId")[0];
		String itemName = rc.getParameter("itemName")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetItemDetailDao dao = factory.getGetItemDetailDao();
		
		rc.setAttribute("itemName", itemName);
		rc.setAttribute("price", dao.getPrice(itemId));
		rc.setAttribute("point", dao.getPoint(itemId));
		rc.setAttribute("itemId",itemId);
		
		
		List item = dao.getItemDetail(itemName);
		System.out.println(item);

		resc.setResult(item);
		if(rc.getSessonAttribute("userId")==null) {
			System.out.println(rc.getAttribute("favoCheck"));
			if(rc.getAttribute("favoCheck")==null) {
				rc.setAttribute("favoCheck", "false");
			}
		}else {
			String userId = (String) rc.getSessonAttribute("userId");
			GetFavoListDao favo = factory.getGetFavoListDao();
			boolean favoCheck = favo.getCheckfavo(userId, itemId);
			rc.setAttribute("favoCheck", favoCheck);
		}

		resc.setTarget("/WEB-INF/userjsp/Item.jsp");
		return resc;
	}
}