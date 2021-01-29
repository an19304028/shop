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

			String sql = "SELECT item_id, item_count FROM shop.cart_table WHERE=";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();

				c.setItemId(rs.getString(1));
				c.setBuyCount(rs.getInt(2));


				cart.add(c);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

}
