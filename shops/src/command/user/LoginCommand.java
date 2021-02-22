package command.user;

import java.util.List;

import bean.User;
import command.AbstractCommand;
import dao.user.GetUserDao;
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
		
		String userId = dao.getUserId(id);
		System.out.println("userID:"+userId);

		if(id.equals(u.getLoginId())) {
			if(pass.equals(u.getPassword())) {
				String path = rc.getOldPath();
				if( path == null) {
					target = "/getcategory?category=new&sort=no";
				}else {
					target = path;
				}
				token = "OK";
				
				rc.setAttribute("itemId", rc.getSessonAttribute("itemId"));
				rc.setAttribute("itemName",rc.getSessonAttribute("itemName"));
				
				rc.setSessionAttribute("userId", userId);
				mes = "ログインしました";
				int point = dao.getPoint(userId);
				System.out.println(point);
				rc.setSessionAttribute("userPoint", point);
				System.out.println(rc.getSessonAttribute("userPoint"));
			}else {
				mes = "パスワードが違います";
				target = "/WEB-INF/userjsp/Login.jsp";
			}
		}else {
			mes = "ログインIDが違います";
			target = "/WEB-INF/userjsp/Login.jsp";
		}

		resc.setTarget(target);
		rc.setAttribute("login",mes);
		rc.setToken(token);
		
		System.out.println("mes:"+rc.getAttribute("mess"));
		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
