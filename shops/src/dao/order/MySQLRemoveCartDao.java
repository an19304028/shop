package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveCartDao implements RemoveCartDao{
	private PreparedStatement st = null;

	@Override
	public void removeCart(String userId,String itemId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.cart_table WHERE user_id=?, item_id=?";
			st = cn.prepareStatement(sql);

			st.setString(1,userId);
			st.setString(2,itemId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
