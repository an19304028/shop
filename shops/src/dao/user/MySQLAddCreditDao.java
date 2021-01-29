package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Credit;
import daofactory.Connector;

public class MySQLAddCreditDao implements AddCreditDao{
	private PreparedStatement st = null;

	@Override
	public void addCredit(Credit c){
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT INTO shop.credit_table VALUES(?, ?, ?, ?, ?)";

			st = cn.prepareStatement(sql);

			st.setString(1, c.getUserId());
			st.setString(2, c.getCardNumber());
			st.setString(3, c.getSecurityCode());
			st.setString(4, c.getExpirationDate());
			st.setInt(5, c.getPayCount());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}





}
