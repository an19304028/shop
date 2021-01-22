package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Cart;
import daofactory.Connector;

public class MySQLAddCartDao implements AddCartDao{
	private PreparedStatement st = null;


	@Override
	public void addCart(Cart c){
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT INTO shop.cart_table(user_id, item_id, buy_count) VALUES(?, ?, ?)";

			st = cn.prepareStatement(sql);

			st.setString(1, c.getUserId());
			st.setString(2, c.getItemId());
			st.setInt(3, c.getBuyCount());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
