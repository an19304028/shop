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
		String sort = null;
		if(rc.getParameter("sort")[0].equals("no")) {
			sort="id";
		}else {
			sort=rc.getParameter("sort")[0];
		}
		System.out.println("sort"+sort);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		GetCategoryDao dao = factory.getGetCategoryDao();
		List item = null;

		if(category.equals("new")) {
			item = dao.getNewItem();
			rc.setAttribute("mess", "新着30件");
			rc.setAttribute("count", 1);
			rc.setAttribute("category","NEW");
			resc.setResult(item);
		}else {
			if(dao.getCategoryCount(category)!=0){
				item = dao.getCategory(category,sort);
				System.out.println(item);
				int count = dao.getCategoryCount(category);
				rc.setAttribute("mess",count+"件");
				rc.setAttribute("category",category);
				rc.setAttribute("count", count);
			}else {
				rc.setAttribute("mess", "商品がありません");
			}
			resc.setResult(item);
		}
		resc.setTarget("/WEB-INF/userjsp/Category.jsp");
		return resc;
	}
}
