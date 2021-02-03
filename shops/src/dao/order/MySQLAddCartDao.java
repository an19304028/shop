package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.Item;
import daofactory.Connector;

public class MySQLAddCartDao implements AddCartDao{
	private PreparedStatement st = null;


	@Override
	public void addCart(Cart c){
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT INTO shop.cart_table VALUES(?, ?, ?)";

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
	public int getStockCount(Cart i) {
		int stock=0;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT stock_count FROM item_table WHERE item_id=?";

			st = cn.prepareStatement(sql);
			st.setString(1, i.getItemId());

			ResultSet rs = st.executeQuery();
			rs.next();
			i.setPrice(rs.getInt(1));
			stock=rs.getInt(1);
			
			
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
}