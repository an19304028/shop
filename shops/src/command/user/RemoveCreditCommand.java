package command.user;

import dao.user.RemoveCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveCreditCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String creditNumber = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCreditDao dao = factory.getRemoveCreditDao();

		dao.RemoveCredit(creditNumber);

		resc.setMess(creditNumber+"を削除しました");

		resc.setTarget("getallusers");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
