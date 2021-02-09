package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLEditUserDao implements EditUserDao{
	private PreparedStatement st = null;

	@Override
	public void editUser(User u) {
		try {
			Connection cn = Connector.connect();

			String sql = "UPDATE shop.user_table SET mail=?, login_id=?, password=?, tell=?, postal_code=?, address=? WHERE user_Id=?";

			st = cn.prepareStatement(sql);

			st.setString(1, u.getMail());
			st.setString(2, u.getLoginId());
			st.setString(3, u.getPassword());
			st.setString(4, u.getTell());
			st.setString(5, u.getPostalCode());
			st.setString(6, u.getAddress());

			st.setString(7, u.getUserId());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}