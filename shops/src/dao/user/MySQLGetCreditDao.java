package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLGetCreditDao implements GetCreditDao {
	private PreparedStatement st = null;
	public void getCredit(String userId) {
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT FROM shop.credit_table WHERE user_id=?";
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
