package command.user;

import dao.user.RemoveCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveCreditCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCreditDao dao = factory.getRemoveCreditDao();

		dao.RemoveCredit(userId);

		resc.setTarget("getallusers");
		System.out.println("");

		return resc;
	}
}
