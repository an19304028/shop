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
		getRequestContext().invalidateSession();
		System.out.println(rc.getSessonAttribute("userId"));
		resc.setTarget("/WEB-INF/userjsp/Logout.jsp");

		System.out.println("target:"+resc.getTarget());

		return resc;
	}

}
