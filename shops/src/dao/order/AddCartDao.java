package dao.order;

import java.util.List;

import bean.Cart;
import bean.Item;

public interface AddCartDao {
	public void addCart(Cart c);
	public int getStockCount(Cart c);
}
