
package command;
//import java.util.Map;
import presentation.RequestContext;
import presentation.ResponseContext;

public abstract class AbstractCommand {
	
	private RequestContext rc;//入力パラメータを格納する
	//private Object result;//コア処理の結果を格納する
	
	public void init(RequestContext rc){
		this.rc=rc;
	}

	protected RequestContext getRequestContext(){
		return rc;
	}
	
	public abstract ResponseContext execute(ResponseContext resc);
}
