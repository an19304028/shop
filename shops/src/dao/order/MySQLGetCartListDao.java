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
	public List getCartList() {
		ArrayList cart = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT user_id, item_id, buy_count FROM shop.cart_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();

				c.setUserId(rs.getString(1));
				c.setItemId(rs.getString(2));
				c.setBuyCount(rs.getInt(3));


				cart.add(c);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

}
