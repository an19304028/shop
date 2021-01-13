package command;

import dao.RemoveUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class RemoveUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0]; 
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		RemoveUserDao dao = factory.getRemoveUserDao();
		System.out.println("削除"+userId);
		dao.removeUser(userId);
		
		resc.setMess(userId+"を削除しました");
		
		resc.setTarget("getusers");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	} 

}
