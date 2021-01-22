package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveCreditDao implements RemoveCreditDao {
	private PreparedStatement st = null;
	public void removeCredit(String userId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.credit_table WHERE user_id=?";
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
