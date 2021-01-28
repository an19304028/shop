package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLGetPasswordDao implements GetPasswordDao {
	private PreparedStatement st = null;

	@Override
	public String getPassword(String userId) {
		User user = new User();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT password  FROM shop.user_table WHERE user_id=?\"";

			st = cn.prepareStatement(sql);
			st.setString(1,userId);

			st.executeUpdate();

			cn.commit();
			cn.close();



			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user.getPassword();
	}

}
