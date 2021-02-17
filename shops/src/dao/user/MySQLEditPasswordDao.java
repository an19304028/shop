package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLEditPasswordDao implements EditPasswordDao{
	private PreparedStatement st = null;
	public void editPassword(User u) {
		try {
			Connection cn = Connector.connect();

			String sql = "UPDATE shop.user_table SET password=? WHERE login_Id=?";

			st = cn.prepareStatement(sql);

			st.setString(1, u.getPassword());
			st.setString(2, u.getLoginId());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
