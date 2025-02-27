package command.item;

import java.util.List;

import command.AbstractCommand;
import dao.item.GetUserItemListDao;
import dao.item.SearchItemDao;
import daofactory.AbstractDaoFactory;
import presentation.RequestContext;
import presentation.ResponseContext;

public class SearchItemCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		
		RequestContext rc = getRequestContext();
		String key = rc.getParameter("key")[0]; 
		SearchItemDao dao = factory.getSearchItemDao();
		String key2 = "%"+key+"%";
		System.out.println("key:"+key2);
		
		List items = null;
		if(dao.getSearchCount(key2)!=0) {
			items = dao.searchItem(key2);
			int count = dao.getSearchCount(key2);
			rc.setAttribute("category",key+" の検索結果："+count+"件");
			rc.setAttribute("count", count);
			rc.setAttribute("sort", 0);
			
		}else {
			rc.setAttribute("sort", 0);
			rc.setAttribute("category","商品が見つかりませんでした");
			
		}
		
		resc.setResult(items);
		resc.setTarget("/WEB-INF/userjsp/Category.jsp");
		System.out.println("target:"+resc.getTarget());
		return resc;
	}
}
