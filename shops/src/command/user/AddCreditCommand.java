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
		String cardNumber = rc.getParameter("cardNumber")[0];
		String securityCode = rc.getParameter("securityCode")[0];
		String expirationMonth = rc.getParameter("expirationMonth")[0];
		String expirationYear = rc.getParameter("expirationYear")[0];
		String payCount = rc.getParameter("payCount")[0];
		
		if(cardNumber!="") {
			System.out.println("20"+ expirationYear+"-0"+expirationMonth+"-01");
			String expirationDate=null;
	
			if(expirationMonth.equals("10")||expirationMonth.equals("11")||expirationMonth.equals("12")) {
				 expirationDate = "20"+ expirationYear+"-"+expirationMonth+"-01";
	
			}else {
				 expirationDate = "20"+ expirationYear+"-0"+expirationMonth+"-01";
	
			}
	
			Credit c = new Credit();
	
	
			c.setUserId(userId);
			c.setCardNumber(cardNumber);
			c.setSecurityCode(securityCode);
			c.setExpirationDate(expirationDate);
			c.setPayCount(Integer.parseInt(payCount));
	
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			AddCreditDao dao = factory.getAddCreditDao();
	
			dao.addCredit(c);
			rc.setAttribute("mess","カードを登録しました");
	
	
			resc.setTarget("inputorder");
			System.out.println("target:"+resc.getTarget());
		}else {
			resc.setTarget("addorder");
			System.out.println("target:"+resc.getTarget());
		}
		return resc;
	}
}
