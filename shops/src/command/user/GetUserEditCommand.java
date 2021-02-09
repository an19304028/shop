package command.user;

import java.util.List;

import command.AbstractCommand;
import dao.admin.GetUserListDao;
import dao.user.GetUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetUserEditCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetUserDao dao = factory.getGetUserDao(); 
		String userId = rc.getParameter("userId")[0];
		
		List users = dao.getUser(userId);
		if(users.size()==0) {
			rc.setAttribute("mess","ユーザーがありません");
		}
		System.out.println(dao.getUser(userId));
		
		resc.setResult(users);
		resc.setTarget("/WEB-INF/userjsp/EditUser.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	} 

}
