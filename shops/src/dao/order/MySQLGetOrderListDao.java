package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import daofactory.Connector;

public class MySQLGetOrderListDao implements GetOrderListDao{

	private PreparedStatement st = null;
	@Override
	public List getOrderList(String userId) {
		ArrayList order = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT item_name, size_name, color_name, item_table.price, buy_date,image_path FROM shop.order_table JOIN shop.order_detail USING(order_id) JOIN shop.item_table USING (item_id) JOIN shop.size_table USING (size_id) JOIN shop.color_table USING(color_id) JOIN shop.image_table USING(item_id) WHERE user_id = ? and image_path LIKE '%samne.jpg'";
			st = cn.prepareStatement(sql);

			st.setString(1, userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Order o = new Order();

				o.setItemName(rs.getString(1));
				o.setSizeName(rs.getString(2));
				o.setColorName(rs.getString(3));
				o.setPrice(rs.getInt(4));
				o.setBuyDate(rs.getString(5));
				o.setImagePath(rs.getString(6));

				order.add(o);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return order;
	}
}
