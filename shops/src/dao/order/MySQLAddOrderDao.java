package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.Order;
import bean.OrderDetail;
import daofactory.Connector;

public class MySQLAddOrderDao implements AddOrderDao{
	PreparedStatement st = null;

	@Override
	public void addOrder(Order o, ArrayList list,int point) {
		try {
			Connection cn = Connector.connect();

			String ordersql = "INSERT INTO shop.order_table(user_id, buy_date, price, item_count) VALUES(?, NOW(0), ?, ?)";

			//order_tableに入れる処理
			st = cn.prepareStatement(ordersql);
			st.setString(1, o.getUserId());
			st.setInt(2, o.getPrice());
			st.setInt(3, o.getItemCount());

			st.executeUpdate();

			//order_detailに入れる処理
			String detailsql = "INSERT INTO shop.order_detail(order_id, item_id, buy_count) VALUES (last_insert_id(), ?, ?)";

			for(int i = 0; i < list.size(); i++) {
				OrderDetail od = (OrderDetail)list.get(i);

				st = cn.prepareStatement(detailsql);
				st.setString(1, od.getItemId());
				st.setInt(2, od.getBuyCount());

				st.executeUpdate();
			}

			String countsql = "UPDATE shop.item_table set stock_count = stock_count - ? where item_id = ?";
			for(int i = 0; i < list.size(); i++) {
				OrderDetail od = (OrderDetail)list.get(i);

				st = cn.prepareStatement(countsql);
				st.setInt(1, od.getBuyCount());
				st.setString(2, od.getItemId());

				st.executeUpdate();
			}

			String pointsql= "UPDATE shop.user_table set point = point + ? where user_id = ?";
			st = cn.prepareStatement(pointsql);
			st.setInt(1, point);
			st.setString(2, o.getUserId());

			st.executeUpdate();

			cn.commit();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
