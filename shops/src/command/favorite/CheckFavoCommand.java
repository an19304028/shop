package command.favorite;

import java.util.List;

import command.AbstractCommand;
import dao.favorite.GetFavoListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class CheckFavoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetFavoListDao dao = factory.getGetFavoListDao();

		String userId = (String)rc.getSessionAttribute("userId");
		String itemId = rc.getParameter("itemId")[0];

		List favo = dao.getFavoList(userId);

		boolean favoCheck = dao.getCheckfavo(userId, itemId);

		System.out.println(favoCheck);

		rc.setAttribute("favoCheck", favoCheck);

		resc.setResult(favo);
		resc.setTarget("getitemdetail");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
