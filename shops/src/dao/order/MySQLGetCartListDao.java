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

			String sql = "SELECT i.item_name, co.color_name, s.size_name, buy_count , TRUNCATE(price/200,0) point ,i.price FROM cart_table c JOIN item_table i USING(item_id) JOIN size_table s USING(size_id) JOIN color_table co USING(color_id) WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();

				c.setItemName(rs.getString(1));
				c.setColorName(rs.getString(2));
				c.setSizeName(rs.getString(3));
				c.setBuyCount(rs.getInt(4));
				c.setPoint(rs.getInt(5));
				c.setPrice(rs.getInt(6));


				cart.add(c);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

}
