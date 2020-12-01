package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import daofactory.Connector;

public class MySQLOrderDao {
	private PreparedStatement st = null;

	public void addOrder(Order o) {
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT into shop.order_table VALUES(?,?,?,?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, o.getOrderId());
			st.setString(2, o.getUserId());
			st.setString(3, o.getBuyDate());
			st.setInt(4, o.getPrice());
			st.setInt(5, o.getItemCount());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public Order getOrder(String orderId) {
		Order o = new Order();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT order_id, user_id, buy_date, price, item_count FROM shop.order_table WHERE order_id=?";
			st = cn.prepareStatement(sql);

			st.setString(1, orderId);

			ResultSet rs = st.executeQuery();
			System.out.println(rs.getString(1));
			rs.next();
			o.setOrderId(rs.getString(1));
			o.setUserId(rs.getString(2));
			o.setBuyDate(rs.getString(3));
			o.setPrice(rs.getInt(4));
			o.setItemCount(rs.getInt(5));


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return o;
	}

	public List<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT order_id, user_id, buy_date, price, item_count FROM shop.order_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getString(1));
				o.setUserId(rs.getString(2));
				o.setBuyDate(rs.getString(3));
				o.setPrice(rs.getInt(4));
				o.setItemCount(rs.getInt(5));

				orders.add(o);

			}
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}


}
