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
			
			String select  = "SELECT * FROM cart_table WHERE user_id=? AND item_id=?";
			st = cn.prepareStatement(select);
			st.setString(1, c.getUserId());
			st.setString(2, c.getItemId());
			
			ResultSet rs = st.executeQuery();
			
			String sql = null;
			
			if(rs.next()==true) {
				rs.close();
				sql ="UPDATE shop.cart_table SET buy_count = buy_count + ? WHERE user_id = ? AND item_id = ?";
				
				st = cn.prepareStatement(sql);
				
				st.setInt(1, c.getBuyCount());
				st.setString(2, c.getUserId());
				st.setString(3, c.getItemId());
				System.out.println("Update");
				st.execute();
				cn.commit();
			}else {
				rs.close();
				sql = "INSERT INTO shop.cart_table VALUES(?, ?, ?)";
	
				st = cn.prepareStatement(sql);
	
				st.setString(1, c.getUserId());
				st.setString(2, c.getItemId());
				st.setInt(3, c.getBuyCount());
				st.execute();
				cn.commit();
			}
			
			
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
	public int getCartCount(Cart i) {
		int count=0;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT SUM(buy_count) FROM cart_table WHERE item_id = ? AND user_id = ? GROUP BY item_id,user_id";

			st = cn.prepareStatement(sql);
			st.setString(1, i.getItemId());
			st.setString(2, i.getUserId());

			ResultSet rs = st.executeQuery();
			if(rs.next()==true) {
				i.setPrice(rs.getInt(1));
				count=rs.getInt(1);
			}else {
				count=0;
			}
			
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}
	public void editCart(Cart c){
		try {
			Connection cn = Connector.connect();

			String sql = "UPDATE shop.cart_table SET buy_count = ? WHERE user_id = ? AND item_id = ?";

			st = cn.prepareStatement(sql);

			st.setInt(1, c.getBuyCount());
			st.setString(2, c.getUserId());
			st.setString(3, c.getItemId());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}