package dao.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLGetItemDetailDao implements GetItemDetailDao{
	private PreparedStatement st = null;

	@Override
	public List getItemDetail(String key) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList item = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, i.item_name, i.stock_count, s.size_name ,c.color_name, ca.category_name, i.price, i.detail FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) Where item_name=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,key);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeName(rs.getString(4));
				i.setColorName(rs.getString(5));
				i.setCategoryName(rs.getString(6));
				i.setPrice(rs.getInt(7));
				i.setDetail(rs.getString(8));
				//i.setImagePath(rs.getString(9));

				item.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item;

	}
	public List getItem(String key) {
		ArrayList item = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, i.item_name, s.size_name ,c.color_name,  i.price FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) Where item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,key);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setSizeName(rs.getString(3));
				i.setColorName(rs.getString(4));
				i.setPrice(rs.getInt(5));
				item.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	public String getPrice(String itemId) {
		String price = null;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT price FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) Where item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,itemId);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				price = rs.getString(1);
			}
		
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	public String getPoint(String itemId) {
		String point = null;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT TRUNCATE(price/200,0) FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) Where item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,itemId);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				point = rs.getString(1);
			}
		
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return point;
	}
	public List getImage(String itemId) {
		ArrayList image = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, im.image_path FROM shop.item_table i JOIN image_table im USING(item_id)  WHERE item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,itemId);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setImagePath(rs.getString(2));
				image.add(i);
				System.out.println("image:"+i.getItemId()+i.getImagePath());
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return image;
	}
	public String getDetail(String itemId) {
		String detail = null;
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT detail FROM shop.item_table  Where item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,itemId);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				detail = rs.getString(1);
			}
		
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return detail;
	}
}