package dao.item;

import java.util.List;

public interface GetCategoryDao {
	List getCategory(String category,String sort);
	int getCategoryCount(String category);
	List getNewItem();
}
