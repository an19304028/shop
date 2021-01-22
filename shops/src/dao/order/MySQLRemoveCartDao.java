package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Order;
import daofactory.Connector;

public class MySQLRemoveCartDao implements RemoveCartDao{
	private PreparedStatement st = null;

	@Override
	public void removeCart(String itemId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.cart_table WHERE item_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,itemId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
