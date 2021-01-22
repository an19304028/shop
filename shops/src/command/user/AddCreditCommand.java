package command.user;

import dao.user.AddCreditDao;
import daofactory.AbstractDaoFactory;

public class AddCreditCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		//String userId = rc.getParameter("userId")[0];
		String creditNumber = rc.getParameter("creditNumber")[0];
		String securityCode = rc.getParameter("securityCode")[0];
		String expirationDate = rc.getParameter("expirationDate")[0];
		String payCount = rc.getParameter("payCount")[0];

		//System.out.println(userId);

		User u = new User();

		//u.setUserId(userId);
		u.setCreditNumber(creditNumber);
		u.setSecurityCode(securityCode);
		u.setExcirationDate(expirationDate);
		u.setPayCount(payCount);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddCreditDao dao = factory.getAddCreditDao();

		dao.addCredit(u);
		resc.setMess(creditNumber+"を登録しました");


		resc.setTarget("/WEB-INF/userjsp/UserRegist.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
