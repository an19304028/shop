package command;

import java.util.List;

import dao.GetAllUsersDao;
import daofactory.AbstractDaoFactory;
import presentation.ResponseContext;

public class GetAllUsersCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetAllUsersDao dao = factory.getAllUsersDao(); 
		
		List users = dao.getAllUsers();
		System.out.println(dao.getAllUsers());
		
		resc.setResult(users);
		resc.setTarget("/WEB-INF/adminjsp/UserList.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	} 

}
