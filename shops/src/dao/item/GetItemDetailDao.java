package dao.item;

import java.util.List;

public interface GetItemDetailDao {
	List getItemDetail(String key);
	List getItem(String key);
	String getPrice(String itemId);
	String getPoint(String itemId);
	List getImage(String itemId);
	String getDetail(String itemId);

}
