package dao.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLGetCategoryDao implements GetCategoryDao{
	private PreparedStatement st = null;
	
	@Override
	public List getCategory(String category) {
		ArrayList list = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql=null;
			if(category.equals("ALL")) {
				sql = "SELECT i.item_id, i.item_name, im.image_path FROM shop.item_table i JOIN image_table im USING(item_id) JOIN category_table c USING(category_id) WHERE image_path LIKE '%samne.jpg%'";
				st = cn.prepareStatement(sql);
			}else {
				sql = "SELECT i.item_id, i.item_name, im.image_path FROM shop.item_table i JOIN image_table im USING(item_id) JOIN category_table c USING(category_id) WHERE category_name=? AND image_path LIKE '%samne.jpg%'";
				st = cn.prepareStatement(sql);
				
				st.setString(1,category);
				
			}
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setImagePath(rs.getString(3));

				list.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int getCategoryCount(String category) {
		int count=0;
		try {
			Connection cn = Connector.connect();
			String sql = null;
			if(category.equals("ALL")) {
				sql = "SELECT COUNT(i.item_id) FROM shop.item_table i JOIN category_table USING(category_id) JOIN image_table im USING(item_id) WHERE image_path LIKE '%samne.jpg%'";
				st = cn.prepareStatement(sql);
			}else {
				sql = "SELECT COUNT(i.item_id) FROM shop.item_table i JOIN category_table USING(category_id) JOIN image_table im USING(item_id) WHERE category_name=? AND image_path LIKE '%samne.jpg%'";
				st = cn.prepareStatement(sql);
				
				st.setString(1,category);
			}
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
