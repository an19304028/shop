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

			String sql = "SELECT REPLACE(item_table.item_id,SUBSTR(item_table.item_id,5,1),'1'), item_name, size_name, color_name, item_table.price, date_format(buy_date, '%Y/%m/%d %H:%i'),image_path FROM shop.order_table JOIN shop.order_detail USING(order_id) JOIN shop.item_table USING (item_id) JOIN shop.size_table USING (size_id) JOIN shop.color_table USING(color_id) JOIN shop.image_table ON(LEFT(shop.item_table.item_id,4)=(LEFT(shop.image_table.item_id,4))) WHERE user_id = ? and image_path LIKE '%samne.jpg' ORDER BY buy_date desc";
			st = cn.prepareStatement(sql);

			st.setString(1, userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Order o = new Order();
				o.setItemId(rs.getString(1));
				o.setItemName(rs.getString(2));
				o.setSizeName(rs.getString(3));
				o.setColorName(rs.getString(4));
				o.setPrice(rs.getInt(5));
				o.setBuyDate(rs.getString(6));
				o.setImagePath(rs.getString(7));

				order.add(o);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return order;
	}
}
