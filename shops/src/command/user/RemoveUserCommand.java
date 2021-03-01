package command.user;

import command.AbstractCommand;
import dao.user.RemoveUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String userId = (String)rc.getSessionAttribute("userId");

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveUserDao dao = factory.getRemoveUserDao();
		System.out.println("削除"+userId);
		dao.removeUser(userId);

		rc.setAttribute("mess",userId+"を削除しました");

		resc.setTarget("getallusers");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
