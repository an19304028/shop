package command.user;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import command.AbstractCommand;
import dao.user.EditUserDao;
import dao.user.GetUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class EditUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String name = rc.getParameter("name")[0];
		String kana = rc.getParameter("kana")[0];
		String gender = rc.getParameter("gender")[0];
		String birthday = rc.getParameter("birthday")[0];
		String mail = rc.getParameter("mail")[0];
		String loginId = rc.getParameter("loginId")[0];
		//String password = rc.getParameter("password")[0];
		String tell = rc.getParameter("tell")[0];
		String postalCode = rc.getParameter("postalCode")[0];
		String address = rc.getParameter("address")[0];
		String userId = rc.getParameter("userId")[0];

		System.out.println("UserId:"+userId+"の情報を編集");

		User u = new User();
		u.setMail(mail);
		u.setLoginId(loginId);
		//u.setPassword(password);
		u.setTell(tell);
		u.setPostalCode(postalCode);
		u.setAddress(address);
		u.setUserId(userId);
		u.setName(name);
		u.setKana(kana);
		u.setBirthday(birthday);
		u.setGender(gender);
		
		ArrayList a = new ArrayList();
		a.add(u);
		
		

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		EditUserDao dao = factory.getEditUserDao();
		
		GetUserDao user = factory.getGetUserDao();

		
		
		
		if(user.getUserId(loginId).equals("noid")==false) {
			rc.setAttribute("mess", "このIDは使われています");
			resc.setResult(a);
			resc.setTarget("/WEB-INF/userjsp/EditUser.jsp");
			System.out.println(u.getName());
			
		}else {
	
			dao.editUser(u);
			rc.setAttribute("mess", "変更しました");
			resc.setTarget("getuser");
			System.out.println("target:"+resc.getTarget());
		}
		

		return resc;
	}


}
