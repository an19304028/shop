package command.user;

import command.AbstractCommand;
import dao.user.RemoveCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String cardNumber = rc.getParameter("cardNumber")[0];
		String point = rc.getParameter("point")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCreditDao dao = factory.getRemoveCreditDao();

		dao.removeCredit(cardNumber);

		rc.setAttribute("mess","削除しました。");

		resc.setTarget("inputorder");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
