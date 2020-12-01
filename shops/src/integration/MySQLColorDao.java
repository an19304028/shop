package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Color;

public class MySQLColorDao implements ColorDao{
	private PreparedStatement st = null;
	private Connection cn = null;
	

	public void addColor(Color c) {
		try {
			Connection cn = Connector.connect();
			
			String sql = "INSERT into shop.color_table VALUES(?,?,?)";
			
			st = cn.prepareStatement(sql);
			
			st.setString(1, c.getColorId());
			st.setString(2, c.getColorName());
			st.setString(3, c.getColorImagePath());
			
			st.executeUpdate();
			
			
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Color getColor(String colorId) {
		Color c = new Color();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT color_id, color_name,color_image_path FROM shop.color_table WHERE color_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, colorId);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			c.setColorId(rs.getString(1));
			c.setColorName(rs.getString(2));
			c.setColorImagePath(rs.getString(3));
				
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public List getAllColors() {
		ArrayList colors = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT color_id, color_name ,color_image_path FROM shop.color_table";
			st = cn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Color c = new Color();
				c.setColorId(rs.getString(1));
				c.setColorName(rs.getString(2));
				c.setColorImagePath(rs.getString(3));
				
				colors.add(c);
				
			}
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return colors;
	}
	
}
