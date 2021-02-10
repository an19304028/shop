package command.user;

import command.AbstractCommand;
import presentation.ResponseContext;

public class InputSendOkCommand extends AbstractCommand {

	public InputSendOkCommand() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("/WEB-INF/userjsp/SendOK.jsp");
		return resc;
	}

}
