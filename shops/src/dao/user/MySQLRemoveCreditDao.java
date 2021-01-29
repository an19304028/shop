package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveCreditDao implements RemoveCreditDao {
	private PreparedStatement st = null;
	public void removeCredit(String cardNumber) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.credit_table WHERE card_number=?";
			st = cn.prepareStatement(sql);
			st.setString(1,cardNumber);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
