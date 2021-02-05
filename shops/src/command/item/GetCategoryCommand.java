package command.item;

import java.util.List;

import command.AbstractCommand;
import dao.item.GetCategoryDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class GetCategoryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rc = getRequestContext();
		String category = rc.getParameter("category")[0];
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCategoryDao dao = factory.getGetCategoryDao(); 
		List item = null;
		if(dao.getCategoryCount(category)!=0) {
			item = dao.getCategory(category);
			System.out.println(item);
			int count = dao.getCategoryCount(category);
			rc.setAttribute("mess",count+"件");
			rc.setAttribute("count", count);
		}else {
			rc.setAttribute("mess", "商品がありません");
		}
		resc.setResult(item);
		
		resc.setTarget("/WEB-INF/userjsp/Category.jsp");
		return resc;
	}
}
