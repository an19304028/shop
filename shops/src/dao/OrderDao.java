package dao;

import java.util.List;

import bean.Order;

public interface OrderDao {
	public abstract void addOrder(Order o);
	public Order getOrder(String orderId);
	public List<?> getAllOrders();
}
