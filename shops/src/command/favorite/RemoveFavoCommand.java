package command.favorite;

import bean.Favorite;
import command.AbstractCommand;
import dao.favorite.RemoveFavoDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveFavoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		String userId = rc.getParameter("userId")[0];
		String itemId = rc.getParameter("itemId")[0];

		Favorite f = new Favorite();

		f.setUserId(userId);
		f.setItemId(itemId);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveFavoDao dao = factory.getRemoveFavoDao();

		dao.removeFavo(f);
		resc.setMess(itemId+"をお気に入りから削除しました");

		resc.setTarget("/WEB-INF/userjsp/FavoList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
