package command.admin;

import java.util.List;

import command.AbstractCommand;
import dao.admin.GetUserListDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetUserListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetUserListDao dao = factory.getUserListDao(); 
		
		List users = dao.getAllUsers();
		if(users.size()==0) {
			rc.setAttribute("mess","ユーザーがありません");
		}
		System.out.println(dao.getAllUsers());
		
		resc.setResult(users);
		resc.setTarget("/WEB-INF/adminjsp/UserList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	} 

}
