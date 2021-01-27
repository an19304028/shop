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

			String sql = "UPDATE shop.user_table SET name=?, kana=?, mail=?, login_id=?, password=?, gender=?, birthday=?, tell=?, postal_code=?, address=? WHERE = user_Id=?";

			st = cn.prepareStatement(sql);

			st.setString(1, u.getName());
			st.setString(2, u.getKana());
			st.setString(3, u.getMail());
			st.setString(4, u.getLoginId());
			//st.setString(5, u.getPassword());
			st.setString(6, u.getGender());
			//st.setString(7, u.getBirthday());
			st.setString(8, u.getTell());
			st.setString(9, u.getPostalCode());
			st.setString(10, u.getAddress());

			st.setString(11, u.getUserId());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}