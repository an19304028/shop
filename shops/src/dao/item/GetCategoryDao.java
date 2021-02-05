package dao.item;

import java.util.List;

public interface GetCategoryDao {
	List getCategory(String category);
	int getCategoryCount(String category);
}
