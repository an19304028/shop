package command.user;

import command.AbstractCommand;
import dao.user.RemoveUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class WithdrawalCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveUserDao dao = factory.getRemoveUserDao();
		System.out.println("削除"+userId);
		dao.removeUser(userId);

		rc.setAttribute("mess","退会しました");
		rc.removeSessionAttribute("userId");

		resc.setTarget("/WEB-INF/userjsp/Logout.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
