package command.user;

import command.AbstractCommand;
import presentation.RequestContext;
import presentation.ResponseContext;

public class LogOutCommand extends AbstractCommand {

	public LogOutCommand() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ResponseContext execute(ResponseContext resc) {
		// TODO 自動生成されたメソッド・スタブ
		RequestContext rc = getRequestContext();
		String userId = (String) rc.getSessionAttribute("userId");
		System.out.println(userId);
		if(userId==null) {
			rc.setAttribute("login", "ログインしてません");
		}else {
			getRequestContext().invalidateSession();
			System.out.println(userId);
			rc.setAttribute("login", "ログアウトしました");
		}
		resc.setTarget("getcategory?category=new&sort=no");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}

}
