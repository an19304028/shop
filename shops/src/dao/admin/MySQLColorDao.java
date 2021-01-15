package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Color;
import daofactory.Connector;

public class MySQLColorDao implements ColorDao{
	private PreparedStatement st = null;


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

	public List getColor(String colorId) {
		ArrayList color = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT color_id, color_name,color_image_path FROM shop.color_table WHERE color_id=?";

			st = cn.prepareStatement(sql);
			st.setString(1, colorId);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {

				Color c = new Color();
				System.out.println(c.getColorId());
				c.setColorId(rs.getString(1));
				c.setColorName(rs.getString(2));
				c.setColorImagePath(rs.getString(3));

				color.add(c);
			}else {
				return null;
			}

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return color;
	}

	public List getAllColors() {
		ArrayList colors = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT color_id, color_name ,color_image_path FROM shop.color_table ORDER BY LENGTH(color_id)";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Color c = new Color();
				c.setColorId(rs.getString(1));
				c.setColorName(rs.getString(2));
				c.setColorImagePath(rs.getString(3));

				colors.add(c);

			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return colors;
	}

	public List getMaxColorId() {
		ArrayList maxId = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT MAX(color_id) FROM shop.color_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			rs.next();
			Color c = new Color();
			String max  = rs.getString(1);
			System.out.println("最大値"+max);
			c.setColorId(max);

			maxId.add(c);
			System.out.println(maxId);

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return maxId;
	}
	public void removeColor(String colorId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.color_table WHERE color_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,colorId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}


