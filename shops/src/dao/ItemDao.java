package dao;

import java.util.List;

import bean.Item;

public interface ItemDao {
	public abstract void addItem(Item i);
	public abstract Item getItem(String itemId);
	public List getAllItems();


}
