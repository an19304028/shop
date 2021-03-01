package command.user;

import java.util.List;

import command.AbstractCommand;
import dao.admin.GetUserListDao;
import dao.user.GetUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetUserDao dao = factory.getGetUserDao(); 
		String userId = (String)rc.getSessionAttribute("userId");
		
		List users = dao.getUser(userId);
		if(users.size()==0) {
			rc.setAttribute("mess","ユーザーがありません");
		}
		System.out.println(dao.getUser(userId));
		
		resc.setResult(users);
		rc.setAttribute("item", users);
		resc.setTarget("/WEB-INF/userjsp/Userinfo.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	} 

}
