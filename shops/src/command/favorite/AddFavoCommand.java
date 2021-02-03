package command.favorite;

import bean.Favorite;
import command.AbstractCommand;
import dao.favorite.AddFavoDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddFavoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();

		String userId = rc.getParameter("userId")[0];
		String itemId = rc.getParameter("itemId")[0];

		Favorite f = new Favorite();

		f.setUserId(userId);
		f.setItemId(itemId);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddFavoDao dao = factory.getAddFavoDao();

		dao.addFavo(f);
		resc.setMess(itemId+"をお気に入りに登録しました");

		resc.setTarget("getfavolist");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
