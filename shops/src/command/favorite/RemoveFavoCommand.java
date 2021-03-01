package command.favorite;

import command.AbstractCommand;
import dao.favorite.RemoveFavoDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveFavoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = (String)rc.getSessionAttribute("userId");
		String itemId = rc.getParameter("itemId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveFavoDao dao = factory.getRemoveFavoDao();

		System.out.println("カートから削除:"+itemId);
		dao.removeFavo(userId, itemId);

		rc.setAttribute("Mess","お気に入りから"+itemId+"を削除しました");

		resc.setTarget("checkfavo");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
