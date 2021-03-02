package command.user;

import bean.User;
import command.AbstractCommand;
import dao.user.AddUserDao;
import dao.user.GetUserDao;
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
		AddUserDao dao = factory.getAddUserDao();
		
		GetUserDao user = factory.getGetUserDao();
		if(user.getUserId(loginId).equals("noid")==false) {
			rc.setAttribute("mess", "このIDは使われています");
			resc.setTarget("/WEB-INF/userjsp/RegistUser.jsp");
			System.out.println(u.getName());
			rc.setAttribute("user", u);
		}else {

			dao.addUser(u);
			rc.setAttribute("mess","ユーザーを登録しました");
	
	
			resc.setTarget("logininput");
			System.out.println("target:"+resc.getTarget());
		}
		return resc;
	}
}
