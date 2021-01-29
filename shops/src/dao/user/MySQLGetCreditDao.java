package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Credit;
import daofactory.Connector;

public class MySQLGetCreditDao implements GetCreditDao {
	private PreparedStatement st = null;
	public List getCredit(String userId) {
		ArrayList credit = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT * FROM shop.credit_table WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,userId);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Credit c = new Credit();

				c.setUserId(rs.getString(1));
				c.setCreditNumber(rs.getString(2));
				c.setSecurityCode(rs.getString(3));
				c.setExpirationDate(rs.getString(4));
				c.setPayCount(rs.getInt(5));


				credit.add(c);
			}
		cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return credit;
	}
}
