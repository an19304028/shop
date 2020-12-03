package command;

import bean.User;
import dao.UserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		//String userId = rc.getParameter("userId")[0];
		String name = rc.getParameter("name")[0];
		String kana = rc.getParameter("kana")[0];
		String mail = rc.getParameter("mail")[0];
		String loginId = rc.getParameter("loginId")[0];
		String password = rc.getParameter("password")[0];
		String gender = rc.getParameter("gender")[0];
		String birthday = rc.getParameter("birthday")[0];
		String tell = rc.getParameter("tell")[0];
		String postalCode = rc.getParameter("postalCode")[0];
		String address = rc.getParameter("address")[0];
		
		//System.out.println(userId);
		
		User u = new User();
		
		//u.setUserId(userId);
		u.setName(name);
		u.setKana(kana);
		u.setMail(mail);
		u.setLoginId(loginId);
		u.setPassword(password);
		u.setGender(gender);
		u.setBirthday(birthday);
		u.setTell(tell);
		u.setPostalCode(postalCode);
		u.setAddress(address);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao dao = factory.getUserDao();
		
		dao.addUser(u);	
		resc.setMess(name+"を登録しました");
				
		
		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		System.out.println("target:"+resc.getTarget());
	
		return resc;
	}
}
