package command.order;

import command.AbstractCommand;
import dao.order.RemoveAllCartDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveAllCartCommand extends AbstractCommand{
	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveAllCartDao dao = factory.getRemoveAllCartDao();

		System.out.println("カートから削除:"+userId);
		dao.removeAllCart(userId);

		rc.setAttribute("mess","カートを空にしました。");
		resc.setTarget("getcartlist");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
