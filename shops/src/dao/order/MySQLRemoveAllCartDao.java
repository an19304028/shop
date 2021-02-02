package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveAllCartDao implements RemoveAllCartDao {
	private PreparedStatement st = null;

	@Override
	public void removeAllCart(String userId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.cart_table WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,userId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
