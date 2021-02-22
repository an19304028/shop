package dao.order;

import bean.Cart;

public interface AddCartDao {
	public void addCart(Cart c);
	public int getStockCount(Cart c);
	public int getCartCount(Cart i);
	public void editCart(Cart c);
}
