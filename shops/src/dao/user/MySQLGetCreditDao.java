package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;
import daofactory.Connector;

public class MySQLGetCreditDao implements GetCreditDao {
	private PreparedStatement st = null;
	public void getCredit(String userId) {
		ArrayList user = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT * FROM shop.credit_table WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				User u = new User();

				u.setUserId(rs.getString(1));
				u.setCreditNumber(rs.getString(2));
				u.setSecurtyCode(rs.getString(3));
				u.setExpirationCode(rs.getString(4));
				u.setPayCount(rs.getInt(5));


				user.add(u);

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
