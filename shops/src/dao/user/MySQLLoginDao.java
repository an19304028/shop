package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLLoginDao implements LoginDao{
	private PreparedStatement st = null;

	@Override
	public User login(String userId) {
		User user = new User();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT password FROM shop.user_table WHERE login_id=?";

			st=cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs =  st.executeQuery();

			user.setPassword(rs.getString(1));

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
