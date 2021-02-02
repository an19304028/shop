package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLLoginDao implements LoginDao{
	private PreparedStatement st = null;

	@Override
	public String login(String userId) {
		User user = new User();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT login_id FROM shop.user_table WHERE login_id=?\"";

			st=cn.prepareStatement(sql);
			st.setString(1, sql);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user.getLoginId();
	}
}
