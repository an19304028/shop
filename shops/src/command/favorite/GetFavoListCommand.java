package command.favorite;

import java.util.List;

import command.AbstractCommand;
import dao.favorite.GetFavoListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetFavoListCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetFavoListDao dao = factory.getGetFavoListDao();

		String userId = rc.getParameter("userId")[0];

		List favo = dao.getFavoList(userId);

		resc.setResult(favo);
		if(favo.size()==0) {
			rc.setAttribute("favo", 0);
		}else {
			rc.setAttribute("favo", 1);
		}
		resc.setTarget("/WEB-INF/userjsp/FavoList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}

