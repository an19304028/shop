package command.user;

import bean.User;
import command.AbstractCommand;
import dao.user.LoginDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class LoginCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		// TODO 自動生成されたメソッド・スタブ

		String target = null;
		String mes = null;
		String token = "NG";

		RequestContext rc = getRequestContext();

		String id = rc.getParameter("loginId")[0];
		String pass = rc.getParameter("pass")[0];


		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		LoginDao dao = factory.getLoginDao();

		User u = dao.login(id);


		if(id.equals(u.getLoginId())) {
			if(pass.equals(u.getPassword())) {
				String path = rc.getOldPath();
				if( path == null) {
					target = "/";
				}else {
					target = path;
				}
				token = "OK";
			}else {
				mes = "パスワードが違います";
				target = "/WEB-INF/userjsp/Login.jsp";
			}
		}else {
			mes = "ログインIDが違います";
			target = "/WEB-INF/userjsp/Login.jsp";
		}

		resc.setTarget(target);
		resc.setMess(mes);
		rc.setToken(token);

		System.out.println("mes:"+resc.getMess());
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
