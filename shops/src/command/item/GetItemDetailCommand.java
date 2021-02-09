package command.item;

import java.util.List;

import command.AbstractCommand;
import dao.item.GetItemDetailDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetItemDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String itemId = rc.getParameter("itemId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetItemDetailDao dao = factory.getGetItemDetailDao();

		List item = dao.getItemDetail(itemId);
		System.out.println(item);

		resc.setResult(item);

		resc.setTarget("/WEB-INF/userjsp/Item.jsp");
		return resc;
	}
}