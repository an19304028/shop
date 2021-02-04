package dao.favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveFavoDao implements RemoveFavoDao{
	private PreparedStatement st = null;

	@Override
	public void removeFavo(String userId, String itemId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.favo_table WHERE user_id=? AND item_id=?";
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
