package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.user.RemoveUserDao;
import daofactory.Connector;

public class MySQLRemoveUserDao implements RemoveUserDao {
	private PreparedStatement st = null;
	public void removeUser(String userId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.user_table WHERE user_id=?";
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
