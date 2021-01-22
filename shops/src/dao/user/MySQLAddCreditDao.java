package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;
import daofactory.Connector;

public class MySQLAddCreditDao implements AddCreditDao{
	private PreparedStatement st = null;

	@Override
	public void addCredit(User u) {
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT INTO shop.credit_table(userId, creditNumber, securityCode, expirationDate, payCount) VALUES(?, ?, ?, ?, ?)";

			st = cn.prepareStatement(sql);

			st.setString(1, u.getUserId());
			st.setString(2, u.getCreditNumber());
			st.setString(3, u.getSecurityCode());
			st.setString(4, u.getExpirationDate());
			st.setString(5, u.getPayCount());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}





}
