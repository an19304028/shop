package command.user;

import command.AbstractCommand;
import dao.user.RemoveCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCreditDao dao = factory.getRemoveCreditDao();

		dao.removeCredit(userId);

		resc.setMess("削除しました");

		resc.setTarget("getallusers");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
