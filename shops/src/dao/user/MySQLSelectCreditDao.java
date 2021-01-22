package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLSelectCreditDao implements SelectCreditDao {
	private PreparedStatement st = null;
	public void selectCredit(String userId) {
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
