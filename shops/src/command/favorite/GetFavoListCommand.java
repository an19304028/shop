package command.favorite;

import bean.Favorite;
import command.AbstractCommand;
import dao.favorite.GetFavoListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetFavoListCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		String userId = rc.getParameter("userId")[0];
		String itemId = rc.getParameter("itemId")[0];

		Favorite f = new Favorite();

		f.setUserId(userId);
		f.setItemId(itemId);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetFavoListDao dao = factory.getGetFavoListDao();

		dao.getFavoList(f);

		resc.setTarget("/WEB-INF/userjsp/FavoList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
