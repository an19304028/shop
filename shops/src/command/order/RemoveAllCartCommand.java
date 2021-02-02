package command.order;

import command.AbstractCommand;
import dao.order.RemoveCartDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveAllCartCommand extends AbstractCommand{
	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveCartDao dao = factory.getRemoveCartDao();

		System.out.println("カートから削除:"+userId);
		dao.removeCart(userId);

		resc.setMess("カートを空にしました。");

		resc.setTarget("getcartlist");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
