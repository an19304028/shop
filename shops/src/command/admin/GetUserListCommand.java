package command;

import java.util.List;

import dao.GetUserListDao;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;

public class GetUserListCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetUserListDao dao = factory.getUserListDao(); 
		
		List users = dao.getAllUsers();
		System.out.println(dao.getAllUsers());
		
		resc.setResult(users);
		resc.setTarget("/WEB-INF/adminjsp/UserList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	} 

}
