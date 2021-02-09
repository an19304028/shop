package command.user;

import bean.User;
import command.AbstractCommand;
import dao.user.EditUserDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class EditUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String mail = rc.getParameter("mail")[0];
		String loginId = rc.getParameter("loginId")[0];
		String password = rc.getParameter("password")[0];
		String tell = rc.getParameter("tell")[0];
		String postalCode = rc.getParameter("postalCode")[0];
		String address = rc.getParameter("address")[0];
		String userId = rc.getParameter("userId")[0];

		System.out.println("UserId:"+userId+"の情報を編集");

		User u = new User();
		u.setMail(mail);
		u.setLoginId(loginId);
		u.setPassword(password);
		u.setTell(tell);
		u.setPostalCode(postalCode);
		u.setAddress(address);
		u.setUserId(userId);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		EditUserDao dao = factory.getEditUserDao();
		dao.editUser(u);
		rc.setAttribute("mess", "変更しました");

		resc.setTarget("getuser");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}


}
