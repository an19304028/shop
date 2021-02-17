package command.user;

import bean.User;
import command.AbstractCommand;
import dao.user.EditPasswordDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;
public class EditPassCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String loginId=rc.getParameter("loginId")[0];
		String password = rc.getParameter("password")[0];

		System.out.println("loginId:"+loginId+"\tpassword:"+password);

		User u = new User();
		u.setLoginId(loginId);
		u.setPassword(password);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		EditPasswordDao dao = factory.getEditPasswordDao();
		dao.editPassword(u);
		//rc.setAttribute("mess", "パスワードを変更しました");

		resc.setTarget("/WEB-INF/userjsp/EditPassOK.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}