package command.user;

import bean.Credit;
import command.AbstractCommand;
import dao.user.AddCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String userId = rc.getParameter("userId")[0];
		String creditNumber = rc.getParameter("creditNumber")[0];
		String securityCode = rc.getParameter("securityCode")[0];
		String expirationDate = rc.getParameter("expirationDate")[0];
		String payCount = rc.getParameter("payCount")[0];

		System.out.println(creditNumber);

		Credit c = new Credit();

		c.setUserId(userId);
		c.setCreditNumber(creditNumber);
		c.setSecurityCode(securityCode);
		c.setExpirationDate(expirationDate);
		c.setPayCount(Integer.parseInt(payCount));

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		AddCreditDao dao = factory.getAddCreditDao();

		dao.addCredit(c);
		resc.setMess(creditNumber+"を登録しました");


		resc.setTarget("/WEB-INF/userjsp/Payment.jsp");
		System.out.println("target:"+resc.getTarget());

		return resc;
	}
}
