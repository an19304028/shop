package command.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Credit;
import command.AbstractCommand;
import dao.user.AddCreditDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class AddCreditCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rc = getRequestContext();
		String userId = (String) rc.getSessionAttribute("userId");
		String cardNumber = rc.getParameter("cardNumber")[0];
		String securityCode = rc.getParameter("securityCode")[0];
		String expirationMonth = rc.getParameter("expirationMonth")[0];
		String expirationYear = rc.getParameter("expirationYear")[0];
		//String payCount = rc.getParameter("payCount")[0];
		
		
		if(cardNumber!="") {
			System.out.println("20"+ expirationYear+"-0"+expirationMonth+"-01");
			String expirationDate=null;
	
			if(expirationMonth.equals("10")||expirationMonth.equals("11")||expirationMonth.equals("12")) {
				 expirationDate = "20"+ expirationYear+"-"+expirationMonth+"-01";
	
			}else {
				 expirationDate = "20"+ expirationYear+"-0"+expirationMonth+"-01";
	
			}
			
			
			 Date date = new Date();
		     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		     System.out.println(sdf.format(date));
		     try {
				date = sdf.parse(sdf.format(date));
				Date date2 = sdf.parse(expirationDate);
				 if(date.after(date2)) {
					 rc.setAttribute("mess","有効期限が切れています");
					 resc.setTarget("inputorder");
						
			     }else {

						Credit c = new Credit();
				
				
						c.setUserId(userId);
						c.setCardNumber(cardNumber);
						c.setSecurityCode(securityCode);
						c.setExpirationDate(expirationDate);
						//c.setPayCount(Integer.parseInt(payCount));
				
						AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
						AddCreditDao dao = factory.getAddCreditDao();
				
						dao.addCredit(c);
						rc.setAttribute("mess","カードを登録しました");
				
				
						resc.setTarget("inputorder");
						System.out.println("target:"+resc.getTarget());
			    	 
			     }
			} catch (ParseException e) {
				
				
			}
		     
	
		}else {
			resc.setTarget("addorder");
			System.out.println("target:"+resc.getTarget());
		}
		return resc;
	}
}
