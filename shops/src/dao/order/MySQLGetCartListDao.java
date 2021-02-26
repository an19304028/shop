package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import daofactory.Connector;

public class MySQLGetCartListDao implements GetCartListDao {
	private PreparedStatement st = null;
	@Override
	public List getCartList(String userId) {
		ArrayList cart = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, i.item_name, co.color_name, s.size_name, buy_count, TRUNCATE(SUM(price * buy_count)/200,0) ,i.price*SUM(buy_count), co.color_image_path FROM cart_table c JOIN item_table i USING(item_id) JOIN size_table s USING(size_id) JOIN color_table co USING(color_id) WHERE user_id=? GROUP BY item_id, user_id";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();

				c.setItemId(rs.getString(1));
				c.setItemName(rs.getString(2));
				c.setColorName(rs.getString(3));
				c.setSizeName(rs.getString(4));
				c.setBuyCount(rs.getInt(5));
				c.setPoint(rs.getInt(6));
				c.setPrice(rs.getInt(7));
				c.setColorImagePath(rs.getString(8));

				cart.add(c);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

	public int getTotalAmount(String userId) {
		int total = 0;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT SUM(price * buy_count) FROM cart_table c JOIN item_table i USING(item_id) JOIN size_table s USING(size_id) JOIN color_table co USING(color_id) WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs = st.executeQuery();


			rs.next();
			total = rs.getInt(1);

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return total;
	}
	public int getPoint(String userId) {
		int point = 0;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT SUM(TRUNCATE(price * buy_count/200,0)) FROM cart_table c JOIN item_table i USING(item_id) JOIN size_table s USING(size_id) JOIN color_table co USING(color_id) WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs = st.executeQuery();


			rs.next();
			point = rs.getInt(1);

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return point;
	}
}
