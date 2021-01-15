package dao.admin;



import java.util.List;

import bean.Item;

public interface ItemDao {
	public void addItem(Item i);
	public void EditItem(Item i);
	public List getAllItem();
	public List getItem(String itemId);
	public void removeItem(String itemId);

}
