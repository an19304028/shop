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

			String sql = "SELECT login_id,password FROM shop.user_table WHERE login_id=?";

			st=cn.prepareStatement(sql);
			st.setString(1, userId);

			ResultSet rs =  st.executeQuery();

			while(rs.next()) {

				user.setLoginId(rs.getString(1));
				user.setPassword(rs.getString(2));
			}

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public String getUserId(String loginId) {
		String userId = null;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT user_id FROM shop.user_table WHERE login_id=?";

			st=cn.prepareStatement(sql);
			st.setString(1, loginId);

			ResultSet rs =  st.executeQuery();
			
			rs.next();
			userId = rs.getString(1);
			

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}
}
