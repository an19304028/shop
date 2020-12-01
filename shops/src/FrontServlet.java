


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AbstractCommand;
import command.CommandFactory;
import presentation.ApplicationController;
import presentation.RequestContext;
import presentation.ResponseContext;
import presentation.WebApplicationController;
import presentation.WebRequestContext;


public class FrontServlet extends javax.servlet.http.HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// doPostを呼び出す
		doPost(req, res);

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		
		ApplicationController app = new WebApplicationController();
		
		RequestContext reqc = app.getRequest(req);
		
		ResponseContext resc = app.handleRequest(reqc);
		resc.setResponse(res);
		app.handleResponse(reqc, resc);
		
		
		
		
		/*
		RequestContext rc = new WebRequestContext();
		rc.setRequest(req);
		//Map data = req.getParameterMap();// Mapとしてパラメータを取得する

		// サーブレットパスを取得し、ConcreteCommandを取得する
		String path = req.getServletPath();
		AbstractCommand command = CommandFactory.getCommand(rc);

		command.init(rc);// コア処理に入力パラメータを渡す

		// コア処理を実行し、戻り値としてViewの情報を取得する
		ResponseContext resc = command.execute();

		// コア処理の実行結果を取得し、登録処理を行う（JSPでの表示に利用）
		//Object result = command.getResult();
		Object result = resc.getResult();
		req.setAttribute("result", result);

		RequestDispatcher dispatcher = req.getRequestDispatcher(resc.getTarget());

		// 転送先に要求を転送する
		dispatcher.forward(req, res);
		*/
	}
}
