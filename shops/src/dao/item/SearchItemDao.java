package dao.item;

import java.util.List;

public interface SearchItemDao {

	List searchItem(String key);
	int getSearchCount(String key);
}
